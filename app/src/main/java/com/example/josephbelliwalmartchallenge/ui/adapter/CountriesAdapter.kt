package com.example.josephbelliwalmartchallenge.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.josephbelliwalmartchallenge.databinding.ItemViewBinding
import com.example.josephbelliwalmartchallenge.model.Country

class CountriesAdapter(
    private val countryList: MutableList<Country> = mutableListOf()
): RecyclerView.Adapter<CountriesViewHolder>() {

    @SuppressLint("NotifyDataSetChange")
    fun updateItems(newItems: List<Country>) {
        if (countryList != newItems) {
            countryList.clear()
            countryList.addAll(newItems)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesViewHolder {
        return CountriesViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: CountriesViewHolder,
        position: Int
    ) = holder.bind(countryList[position])

    override fun getItemCount(): Int = countryList.size

}

class CountriesViewHolder(
    private val binding: ItemViewBinding
) : ViewHolder(binding.root) {

    fun bind(country: Country) {
        binding.txtName.text = country.name
        binding.txtRegion.text = country.region
        binding.txtCode.text = country.code
        binding.txtCapital.text = country.capital
    }
}