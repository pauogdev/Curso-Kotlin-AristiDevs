package com.pauortegarcia.cursokotlin.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ActivityFirstAppBinding

class FirstAppActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFirstAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstAppBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPulsame.setOnClickListener{
            val name = binding.etname.text.toString()

            if(name.isNotEmpty()){
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("extra_name","Bienvenido $name" )
                startActivity(intent)
            }
        }
    }
}