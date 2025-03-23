package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carModelGroup: RadioGroup = findViewById(R.id.carModelGroup)
        val klimatyzacja: CheckBox = findViewById(R.id.klimatyzacja)
        val skorzaneSiedzenia: CheckBox = findViewById(R.id.skorzanesiedzenia)
        val carImage: ImageView = findViewById(R.id.carImage)
        val showSummaryButton: Button = findViewById(R.id.showSummaryButton)
        val summaryText: TextView = findViewById(R.id.summaryText)

        showSummaryButton.setOnClickListener {

            val selectedCarModel: String = when (carModelGroup.checkedRadioButtonId) {
                R.id.sedan -> "Sedan"
                R.id.suv -> "SUV"
                R.id.hatchback -> "Hatchback"
                else -> "Brak wybranego modelu"
            }

            val klimatyzacjaText = if (klimatyzacja.isChecked) "Klimatyzacja" else "Brak klimatyzacji"
            val skorzaneSiedzeniaText = if (skorzaneSiedzenia.isChecked) "Skórzane Siedzenia" else "Brak skórzanych siedzeń"

            val summary = "Model: $selectedCarModel\n$klimatyzacjaText\n$skorzaneSiedzeniaText"
            summaryText.text = summary

            when (selectedCarModel) {
                "Sedan" -> carImage.setImageResource(R.drawable.sedan)
                "SUV" -> carImage.setImageResource(R.drawable.suv)
                "Hatchback" -> carImage.setImageResource(R.drawable.hatchback)
            }
        }
    }
}
