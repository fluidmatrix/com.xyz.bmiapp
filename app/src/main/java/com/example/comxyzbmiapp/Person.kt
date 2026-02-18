package com.example.comxyzbmiapp

import kotlin.math.pow
import kotlin.math.round

class Person(
    val age: Int,
    val gender: String,
    val weight: Double,
    val height: Double
) {
    fun calculateBMI(): Double {
        return weight / (height * height)
    }

    fun getBMIStatus(): BMIStatus {
        val bmi = calculateBMI()
        return when {
            bmi < 18.5 -> BMIStatus.UNDERWEIGHT
            bmi <= 24.9 -> BMIStatus.NORMAL
            else -> BMIStatus.OVERWEIGHT
        }
    }
}
