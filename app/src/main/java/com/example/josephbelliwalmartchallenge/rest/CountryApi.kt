package com.example.josephbelliwalmartchallenge.rest

import com.example.josephbelliwalmartchallenge.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET("countries.json")
    suspend fun getCountries(): Response<List<Country>>

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"
    }
}