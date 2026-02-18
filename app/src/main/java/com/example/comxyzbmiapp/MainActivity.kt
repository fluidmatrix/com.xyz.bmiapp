package com.example.comxyzbmiapp

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import com.example.comxyzbmiapp.Person
import com.example.comxyzbmiapp.BMIStatus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etAge = findViewById<EditText>(R.id.etAge)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {

            val ageText = etAge.text.toString()
            val weightText = etWeight.text.toString()
            val heightText = etHeight.text.toString()

            if (ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty() || rgGender.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = when (rgGender.checkedRadioButtonId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> ""
            }

            val person = Person(
                ageText.toInt(),
                gender,
                weightText.toDouble(),
                heightText.toDouble()
            )

            val bmi = person.calculateBMI()
            val bmiFormatted = String.format("%.2f", bmi)  // Round to 2 decimal places
            val status = person.getBMIStatus()

            when (status) {
                BMIStatus.UNDERWEIGHT -> {
                    tvResult.setTextColor(Color.RED)
                    tvResult.text = "BMI: $bmiFormatted\nYou are Underweight"
                }
                BMIStatus.NORMAL -> {
                    tvResult.setTextColor(Color.GREEN)
                    tvResult.text = "BMI: $bmiFormatted\nYour weight is Normal"
                }
                BMIStatus.OVERWEIGHT -> {
                    tvResult.setTextColor(Color.RED)
                    tvResult.text = "BMI: $bmiFormatted\nYou are Overweight"
                }
            }
        }
    }
}
