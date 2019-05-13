package com.example.login

import android.app.Application
import androidx.annotation.StringRes
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.api.ApiRepository
import com.example.api.User
import com.example.base.ktx.onPropertyChanged
import io.reactivex.rxkotlin.subscribeBy

class LoginViewModel(application: Application, val apiRepository: ApiRepository) : AndroidViewModel(application) {

    val username = ObservableField<String>()
    val password = ObservableField<String>()
    val usernameError = ObservableField<String>()
    val passwordError = ObservableField<String>()

    val userLoggedIn = MutableLiveData<User>()
    val loginError = MutableLiveData<Throwable>()

    init {
        username.onPropertyChanged { usernameError.set(null) }
        password.onPropertyChanged { passwordError.set(null) }
    }

    fun onLoginClick() {
        var valid = true
        if (username.get().isNullOrEmpty()) {
            usernameError.set(getString(R.string.error_username))
            valid = false
        }
        if (password.get().isNullOrEmpty() || password.get()!!.length < 8) {
            passwordError.set(getString(R.string.error_password))
            valid = false
        }
        if (valid) {
            val subscription = apiRepository.login(username.get()!!, password.get()!!)
                .subscribeBy(
                    onNext = { user -> userLoggedIn.postValue(user) },
                    onError = { throwable -> loginError.postValue(throwable) }
                )
        }
    }

    private fun getString(@StringRes resId: Int) = getApplication<Application>().getString(resId)
}
