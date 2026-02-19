package com.example.comxyzbmiapp



class Person(
    val name: String,
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
