package com.wafihasan.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()
{

    private var selectedDateTextView : TextView? = null
    private var inMinutesTextView: TextView? = null
    private var inDaysTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickerButton : Button = findViewById(R.id.datePickerButton)

        selectedDateTextView = findViewById(R.id.selectedDateTextView)
        inMinutesTextView = findViewById(R.id.inMinutesTextView)
        inDaysTextView = findViewById(R.id.inDaysTextView)

        datePickerButton.setOnClickListener{
            clickDatePicker()

        }
    }

    private fun clickDatePicker()
    {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
        this,
        {
            _, year, month, day ->

//            Toast.makeText(this, "DatePicker pressed", Toast.LENGTH_LONG).show()
//            Toast.makeText(this, "Year was $year", Toast.LENGTH_LONG).show()
//            Toast.makeText(this, "Month was ${month+1}", Toast.LENGTH_LONG).show()
//            Toast.makeText(this, "Day was $day", Toast.LENGTH_LONG).show()

            val selectedDate = "$day/${month + 1}/$year"

            val simpleDateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy");
            val date = simpleDateFormat.parse(selectedDate);

            selectedDateTextView?.text = simpleDateFormat.format(simpleDateFormat.parse(selectedDate)) //can also use .setText() but now, using property is recommended

            val dateInMinutes = date.time / 60000; // returns time since Jan 1 1970 in milliseconds. Divide by 1000 to get seconds
            //Then by 60 to get minutes. Hence, 60000

            val dateInDays = date.time / 1000 / 60 / 60 / 24

            val currentTime = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis())).time / 60000
            val differenceInMinutes = currentTime - dateInMinutes

            val dateToday = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis())).time / 86400000
            val diff = dateToday - dateInDays

            inMinutesTextView?.text = differenceInMinutes.toString();
            inDaysTextView?.text = diff.toString()

        },
            year, month, day)

        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show();

//        Toast.makeText(this, "Button Pressed", Toast.LENGTH_LONG).show()
    }
}