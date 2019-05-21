package com.example.integration.test

import cucumber.api.CucumberOptions

@CucumberOptions(glue = ["com.example.integration.steps"], features = ["features"])
class Options