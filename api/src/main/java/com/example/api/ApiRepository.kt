package com.example.api

import io.reactivex.Observable

class ApiRepository {

    fun login(username: String, password: String): Observable<User> =
        if (username == "test" && password == "hello123") {
            Observable.just(User("Test"))
        } else {
            Observable.error(Throwable("Bad login"))
        }
}
