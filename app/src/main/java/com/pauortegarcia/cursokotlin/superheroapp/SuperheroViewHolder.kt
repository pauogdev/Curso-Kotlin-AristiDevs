package com.pauortegarcia.cursokotlin.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pauortegarcia.cursokotlin.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superHeroItemResponse.name
        Picasso.get().load(superHeroItemResponse.image.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener { onItemSelected(superHeroItemResponse.id) }
    }
}