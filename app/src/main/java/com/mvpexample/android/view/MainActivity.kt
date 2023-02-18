package com.mvpexample.android.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mvpexample.android.R
import com.mvpexample.android.model.Person
import com.mvpexample.android.presenter.CalculateAge
import com.mvpexample.android.presenter.ICalculateAge

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity(), CalculateAge.View {

    lateinit var calculateAgePresenter: ICalculateAge
    lateinit var textViewInfo: TextView
    lateinit var editTextName: EditText
    lateinit var editTextAge: EditText
    lateinit var buttonCalculateAge: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateAgePresenter = CalculateAge(this)
        textViewInfo = findViewById(R.id.tv_your_age)
        editTextName = findViewById(R.id.et_name)
        editTextAge = findViewById(R.id.et_age)
        buttonCalculateAge = findViewById(R.id.bt_calculate)

        buttonCalculateAge.setOnClickListener {
            val name = editTextName.text.trim().toString()
            val age = editTextAge.text.trim().toString().toInt()
            calculateAgePresenter.calculateYourAge(name, age)
        }

    } //onCreate()

    override fun getInfo(person: Person) {
        textViewInfo.text = "${person.name} your age: ${person.age}"
    }

}