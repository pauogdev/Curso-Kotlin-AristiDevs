package com.pauortegarcia.cursokotlin.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ActivityImcappBinding
import java.text.DecimalFormat

private var isSelected: Boolean = true
private var currentWeight: Int = 60
private var currentAge: Int = 30
private var currentHeight: Int = 120


class IMCAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcappBinding

    companion object {
        const val IMC_KEY = "calculoImc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcappBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
        initUI()

    }

    private fun initUI() {
        setAge()
        setWeight()
        setGenderColor()
    }

    private fun initListener() {
        binding.viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        binding.viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        binding.rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            binding.tvHeight.text = "$currentHeight cm"
        }

        binding.btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        binding.btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        binding.btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        binding.btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        binding.calculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra("calculoImc", result)
        startActivity(intent)

    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun setWeight() {
        binding.tvPeso.text = currentWeight.toString()
    }

    private fun setAge() {
        binding.tvAge.text = currentAge.toString()
    }

    private fun changeGender() {
        if (isSelected) {
            setGenderColor()
            isSelected = false
        } else {
            setGenderColor()
            isSelected = true
        }

    }

    private fun setGenderColor() {
        binding.viewMale.setCardBackgroundColor(getBackgroundColor(isSelected))
        binding.viewFemale.setCardBackgroundColor(getBackgroundColor(!isSelected))
    }


    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val selectColor = if (isSelectedComponent) {
            R.color.background_component_select
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, selectColor)
    }


}