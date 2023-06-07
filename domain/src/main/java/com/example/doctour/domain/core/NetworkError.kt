package com.example.doctour.domain.core

sealed class NetworkError {
    class Unexpected(val error: String) : NetworkError()

    class Api(val error: String?) : NetworkError()

    class ApiInputs(val error: MutableMap<String, List<String>>?) : NetworkError()


    object Timeout : NetworkError()
}