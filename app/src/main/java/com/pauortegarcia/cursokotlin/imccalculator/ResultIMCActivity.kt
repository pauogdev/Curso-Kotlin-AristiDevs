package com.pauortegarcia.cursokotlin.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ActivityResultImcactivityBinding
import com.pauortegarcia.cursokotlin.imccalculator.IMCAppActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultImcactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        binding.reCalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUI(result: Double) {
        binding.tvIMC.text= result.toString()

        when(result){
            in 0.00..18.50 ->{ //bajo Peso
                binding.tvResult.text=getString(R.string.title_bajo_peso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                binding.tvDescription.text=getString(R.string.description_bajo_peso)
            }

            in 18.51..24.99 ->{ //Normal
                binding.tvResult.text=getString(R.string.title_normal_peso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                binding.tvDescription.text=getString(R.string.description_normal_peso)
            }

            in 25.00..29.99 ->{ //Sobre Peso
                binding.tvResult.text=getString(R.string.title_sobrepeso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                binding.tvDescription.text=getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00 ->{ //Obesidad
                binding.tvResult.text=getString(R.string.title_obesidad)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                binding.tvDescription.text=getString(R.string.description_obesidad)
            }
            else->{ //Error
                binding.tvIMC.text=getString(R.string.error)
                binding.tvResult.text=getString(R.string.error)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                binding.tvDescription.text=getString(R.string.error)
            }

        }
    }
}