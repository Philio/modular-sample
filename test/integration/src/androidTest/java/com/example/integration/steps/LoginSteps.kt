package com.example.integration.steps

import android.util.Log
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class LoginSteps {

    @When("^User logs in$")
    fun userLogsIn() {
        Log.d("Integration", "When User logs in")
    }

    @Then("^User is logged in$")
    fun userIsLoggedIn() {
        Log.d("Integration", "Then User is logged in")
    }
}