package com.example.josephbelliwalmartchallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.josephbelliwalmartchallenge.model.Country
import com.example.josephbelliwalmartchallenge.rest.CountriesRepositoryImpl
import com.example.josephbelliwalmartchallenge.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val countryRepository = CountriesRepositoryImpl()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    private val _countries: MutableStateFlow<UIState<List<Country>>> = MutableStateFlow(UIState.LOADING)
    val countries: StateFlow<UIState<List<Country>>> = _countries

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch(dispatcher) {
            countryRepository.getCountries().collect {
                _countries.value = it
            }
        }
    }
}