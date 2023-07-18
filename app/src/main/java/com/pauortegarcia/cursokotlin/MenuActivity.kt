package com.pauortegarcia.cursokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pauortegarcia.cursokotlin.databinding.ActivityMenuBinding
import com.pauortegarcia.cursokotlin.firstapp.FirstAppActivity
import com.pauortegarcia.cursokotlin.imccalculator.IMCAppActivity
import com.pauortegarcia.cursokotlin.superheroapp.SuperHeroListActivity
import com.pauortegarcia.cursokotlin.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
    }

    private fun listener(){
        binding.btnSaludApp.setOnClickListener { navegateToSaludApp() }
        binding.btnIMCApp.setOnClickListener { navegateToIMCApp() }
        binding.btnTodo.setOnClickListener { navegateToTodoApp() }
        binding.btnSuperHeroApp.setOnClickListener { navegateToSuperHeroApp() }
    }

    private fun navegateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java )
        startActivity(intent)
    }


    private fun navegateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java )
        startActivity(intent)
    }

    private fun navegateToIMCApp() {
        val intent = Intent(this, IMCAppActivity::class.java )
        startActivity(intent)
    }

    private fun navegateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}