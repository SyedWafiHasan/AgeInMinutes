package com.wafihasan.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickerButton : Button = findViewById(R.id.datePickerButton)

        datePickerButton.setOnClickListener{
            clickDatePicker()

        }
    }

    fun clickDatePicker()
    {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
        this,
        {
                _, year, month, day ->
                Toast.makeText(this, "DatePicker pressed", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Year was $year", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Month was $month", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Day was $day", Toast.LENGTH_LONG).show()
        },
            year, month, day).show()

        Toast.makeText(this, "Button Pressed", Toast.LENGTH_LONG).show()
    }
}