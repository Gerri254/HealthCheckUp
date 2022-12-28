package com.gerald.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gerald.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue=30
        binding.weightPicker.maxValue=180

        binding.heightPicker.minValue=70
        binding.heightPicker.maxValue=250

        binding.weightPicker.setOnValueChangedListener{_,_,_ ->

            calculatorBMI()
        }
        binding.heightPicker.setOnValueChangedListener{_,_,_ ->

            calculatorBMI()
        }

    }

    private fun calculatorBMI()
    {
       val height = binding.heightPicker.value
       val doubleHeight = height.toDouble()/100

       val weight =binding.weightPicker.value

       val bmi = weight.toDouble()/(doubleHeight * doubleHeight)

        binding.resultTV.text= String.format("Your BMI is: %.2f",bmi)
        binding.healthyTV.text= String.format("considered to be: %s",healthyMessage(bmi))

    }

    private fun healthyMessage(bmi:Double):String
    {
        if(bmi < 18.5)
            return "Underweight Please Eat More"
        if (bmi < 25.0)
            return "Healthy,continue with your diet routine"
        if (bmi <30.0)
            return "Overweight,change of diet to be considered an option"

        return "Obese...Please consider seeking for help"
    }
}