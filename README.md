# Sample of a modular app using Dagger

## Modules

### App

* Custom application class
* Creates Dagger graph

### Base

* Provides dependencies for all features (currently just Material library and default theme/colours)

### Main

* An example main activity with nav drawer (using navigation component)

### FeatureX

* A fragment included in the main activity

### Login

* A simple tested example of a login screen that shows a snackbar indicating the result
* Unit tests (TDD) with JUnit and MockK
* UI tests (BDD) with Cucumber Android and MockK

### API

* A fake API that returns successful response with `test`/`hello123` credentials

### Test/Integration

* An empty test suite for integration testing using BDD (Cucumber Android) with a single dummy test

## Tests

### Running login tests

#### Unit tests

`./gradlew :login:test`

#### UI tests

`./gradlew :login:connectedAndroidTest`

### Running integration tests

`./gradlew :test:integration:connectedAndroidTest`