package com.pauortegarcia.cursokotlin.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauortegarcia.cursokotlin.databinding.ActivitySuperHeroListBinding
import com.pauortegarcia.cursokotlin.superheroapp.DetailSuperHeroActivity.Companion.DETAILS_ID
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.svSuperHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adapter = SuperheroAdapter{navigateToDetail(it)}
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHero.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if (myResponse.isSuccessful){
                Log.i ("pauortega", "funciona")
                val response = myResponse.body()
                if(response != null && response.response == "success"){
                    Log.i("pauortega", response.toString())
                    runOnUiThread{
                        adapter.updateList(response.superHero)
                        binding.progressBar.isVisible = false
                    }
                }else{
                    runOnUiThread{
                        binding.progressBar.isVisible = false
                        Log.i("pauortega", "response es null")
                    }


                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun navigateToDetail(id:String) {
        val intent = Intent(this, DetailSuperHeroActivity::class.java)
        intent.putExtra(DETAILS_ID, id)
        startActivity(intent)
    }


}