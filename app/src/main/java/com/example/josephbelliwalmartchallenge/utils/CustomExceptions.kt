package com.example.josephbelliwalmartchallenge.utils

class NullResponse(message: String = "Response is null") : Exception(message)
class ResponseFailure(message: String?) : Exception(message)