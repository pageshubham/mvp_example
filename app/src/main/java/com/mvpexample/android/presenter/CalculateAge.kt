package com.mvpexample.android.presenter

import com.mvpexample.android.model.Person
import java.util.Calendar

class CalculateAge(private val view: View) : ICalculateAge {

    override fun calculateYourAge(name: String, age: Int) {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val yourAge = currentYear - age
        val person = Person(name, yourAge)
        view.getInfo(person)
    }

    interface View {
        fun getInfo(person: Person)
    }
}