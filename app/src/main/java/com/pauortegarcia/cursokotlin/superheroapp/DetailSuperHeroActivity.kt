package com.pauortegarcia.cursokotlin.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pauortegarcia.cursokotlin.R

class DetailSuperHeroActivity : AppCompatActivity() {
    companion object {
        const val DETAILS_ID = "detailsId"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_super_hero)
    }
}