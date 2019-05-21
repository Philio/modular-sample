package com.example.login

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.api.ApiRepository
import com.example.api.User
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

const val USERNAME_ERROR = "Username error"
const val PASSWORD_ERROR = "Password error"

internal class LoginViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    lateinit var application: Application

    @MockK
    lateinit var apiRepository: ApiRepository

    lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        every { application.getString(R.string.error_username) } returns USERNAME_ERROR
        every { application.getString(R.string.error_password) } returns PASSWORD_ERROR
        every { apiRepository.login(any(), any()) } returns Observable.empty()

        loginViewModel = LoginViewModel(application, apiRepository)
    }

    @Test
    fun `Given username is empty When login button clicked Then username error should be shown`() {
        loginViewModel.username.set(null)

        loginViewModel.onLoginClick()

        verify { application.getString(R.string.error_username) }
        assertEquals(USERNAME_ERROR, loginViewModel.usernameError.get())
    }

    @Test
    fun `Given password is empty When login button clicked Then show password error`() {
        loginViewModel.password.set(null)

        loginViewModel.onLoginClick()

        verify { application.getString(R.string.error_password) }
        assertEquals(PASSWORD_ERROR, loginViewModel.passwordError.get())
    }

    @Test
    fun `Given password is shorter than 8 characters When login button clicked Then show password error`() {
        loginViewModel.password.set("short")

        loginViewModel.onLoginClick()

        verify { application.getString(R.string.error_password) }
        assertEquals(PASSWORD_ERROR, loginViewModel.passwordError.get())
    }

    @Test
    fun `Given username has an error When user starts typing in username field Then username error is cleared`() {
        loginViewModel.usernameError.set(USERNAME_ERROR)

        loginViewModel.username.set("username")

        assertNull(loginViewModel.usernameError.get())
    }

    @Test
    fun `Given password has an error When user starts typing in password field Then password error is cleared`() {
        loginViewModel.passwordError.set(PASSWORD_ERROR)

        loginViewModel.password.set("password")

        assertNull(loginViewModel.passwordError.get())
    }

    @Test
    fun `Given credentials are valid When login button clicked Then call api`() {
        val username = "username"
        val password = "password"
        loginViewModel.username.set(username)
        loginViewModel.password.set(password)

        loginViewModel.onLoginClick()

        verify { apiRepository.login(username, password) }
    }

    @Test
    fun `Given user credentials are valid When login button clicked Then notify success observers`() {
        val user = User("Test")
        every { apiRepository.login(any(), any()) } returns Observable.just(user)
        val username = "username"
        val password = "password"
        loginViewModel.username.set(username)
        loginViewModel.password.set(password)

        loginViewModel.onLoginClick()

        assertEquals(user, loginViewModel.userLoggedIn.value)
    }

    @Test
    fun `Given user credentials are invalid When login button clicked Then notify error observers`() {
        val error = Throwable("Bad times")
        every { apiRepository.login(any(), any()) } returns Observable.error(error)
        val username = "badusername"
        val password = "badpassword"
        loginViewModel.username.set(username)
        loginViewModel.password.set(password)

        loginViewModel.onLoginClick()

        assertEquals(error, loginViewModel.loginError.value)
    }
}
