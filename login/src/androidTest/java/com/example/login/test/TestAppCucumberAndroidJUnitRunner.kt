package com.example.login.test

import android.app.Application
import android.content.Context
import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberAndroidJUnitRunner

@CucumberOptions(glue = ["com.example.login.steps"], features = ["features"])
class TestAppCucumberAndroidJUnitRunner : CucumberAndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApp::class.qualifiedName, context)
    }
}