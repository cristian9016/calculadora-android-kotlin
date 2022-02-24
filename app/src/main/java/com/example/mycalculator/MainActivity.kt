package com.example.mycalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSuma.setOnClickListener {
            hacerOperacion(Operacion.SUMA)
        }
        binding.btnResta.setOnClickListener {
            hacerOperacion(Operacion.RESTA)
        }
        binding.btnMultiplicacion.setOnClickListener {
            hacerOperacion(Operacion.MULTIPLICACION)
        }
        binding.btnDivision.setOnClickListener {
            hacerOperacion(Operacion.DIVISION)
        }
    }

    private fun hacerOperacion(operacion: Operacion) {
        val num1 = binding.num1.text.toString().toDouble()
        val num2 = binding.num2.text.toString().toDouble()
        val res = when (operacion) {
            Operacion.SUMA -> num1 + num2
            Operacion.RESTA -> num1 - num2
            Operacion.MULTIPLICACION -> num1 * num2
            Operacion.DIVISION -> num1 / num2
        }
        binding.result.text = res.toString()
    }

    enum class Operacion {
        SUMA, RESTA, MULTIPLICACION, DIVISION
    }
}
