package com.example.josephbelliwalmartchallenge.rest

import com.example.josephbelliwalmartchallenge.model.Country
import com.example.josephbelliwalmartchallenge.utils.NullResponse
import com.example.josephbelliwalmartchallenge.utils.ResponseFailure
import com.example.josephbelliwalmartchallenge.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface CountryRepository {
    fun getCountries(): Flow<UIState<List<Country>>>
}

class CountriesRepositoryImpl : CountryRepository {

    override fun getCountries(): Flow<UIState<List<Country>>> = flow {
        emit(UIState.LOADING)
        try {
            val response = RetrofitHelper.service.getCountries()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: throw NullResponse()

            } else {
                throw ResponseFailure(response.errorBody()?.string())
            }

        } catch (error: Exception) {
            emit(UIState.ERROR(error))
        }
    }

}