package com.example.login.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.api.ApiRepository
import com.example.api.User
import com.example.login.LoginActivity
import com.example.login.R
import com.example.login.test.DaggerTestAppComponent
import com.example.login.test.TestApp
import com.example.login.test.TestMocksModule
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import org.junit.Assert.assertNotNull

class LoginSteps {

    var rule = ActivityTestRule<LoginActivity>(LoginActivity::class.java, false, false)

    @MockK
    lateinit var apiRepository: ApiRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as TestApp

        DaggerTestAppComponent.factory().create(app, TestMocksModule(apiRepository)).inject(app)

        rule.launchActivity(null)
    }

    @After
    fun teardown() {
        rule.activity.finish()
    }

    @Given("I have a LoginActivity")
    fun hasloginActivity() {
        assertNotNull(rule.activity)
    }

    @When("^I enter the username (\\S+)$")
    fun enterUsername(username: String) {
        every { apiRepository.login(any(), any()) } returns Observable.just(User(username))
        onView(withId(R.id.username)).perform(click(), typeText(username))
    }

    @When("^I enter the password (\\S+)$")
    fun enterPassword(password: String) {
        onView(withId(R.id.password)).perform(click(), typeText(password))
    }

    @When("I press the login button")
    fun pressLoginButton() {
        closeSoftKeyboard()
        onView(withId(R.id.button_login)).perform(click())
    }

    @Then("^I should see a snackbar with a welcome message for (\\S+)$")
    fun snackbarIsShown(username: String) {
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(withText("Hi, $username!")))
    }
}