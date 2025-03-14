package com.example.josephbelliwalmartchallenge.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.josephbelliwalmartchallenge.R
import com.example.josephbelliwalmartchallenge.databinding.ActivityMainBinding
import com.example.josephbelliwalmartchallenge.ui.adapter.CountriesAdapter
import com.example.josephbelliwalmartchallenge.ui.viewmodel.CountryViewModel
import com.example.josephbelliwalmartchallenge.utils.NullResponse
import com.example.josephbelliwalmartchallenge.utils.UIState
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val countryViewModel by lazy {
        ViewModelProvider(this)[CountryViewModel::class.java]
    }

    private val recyclerAdapter by lazy {
        CountriesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = recyclerAdapter
        }

        getCountries()
    }

    private fun getCountries() {
        lifecycleScope.launch {
            countryViewModel.countries.collect { state ->
                when (state) {
                    UIState.LOADING -> {
                        Toast.makeText(this@MainActivity, "Loading...", Toast.LENGTH_SHORT).show()
                    }

                    is UIState.ERROR -> {
                        Toast.makeText(this@MainActivity, state.error.message, Toast.LENGTH_LONG).show()
                    }

                    is UIState.SUCCESS -> {
                        recyclerAdapter.updateItems(state.response)
                    }

                }
            }
        }
    }

}