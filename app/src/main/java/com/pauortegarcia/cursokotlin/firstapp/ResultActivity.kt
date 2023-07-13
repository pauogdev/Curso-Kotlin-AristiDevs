package com.pauortegarcia.cursokotlin.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name:String = intent.extras?.getString("extra_name").orEmpty()
        binding.saludo.text = name
    }
}