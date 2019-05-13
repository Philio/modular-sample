package com.example.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.login.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: LoginViewModelFactory

    val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
    }
    val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        viewModel.userLoggedIn.observe(this, Observer {
            Snackbar.make(binding.root, "Hi, ${it.name}!", Snackbar.LENGTH_LONG).show()
        })
        viewModel.loginError.observe(this, Observer {
            Snackbar.make(binding.root, "Something went wrong :(", Snackbar.LENGTH_LONG).show()
        })
    }
}
