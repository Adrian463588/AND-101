package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // View binding for easier view references
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the Calculate button to trigger the tip calculation
        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    // Suppressing "SetTextI18n" warning due to string concatenation
    @SuppressLint("SetTextI18n")
    private fun calculateTip() {
        // Get the cost input from the user
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        // If the cost input is invalid or empty, show 0 tip and return
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        // Determine the selected tip percentage
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        // Calculate the tip
        var tip = cost * tipPercentage

        // Check if the round-up switch is enabled
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        // Display the calculated tip
        displayTip(tip)
    }

    @SuppressLint("SetTextI18n")
    private fun displayTip(tip: Double) {
        // Format the tip amount as currency
        val formattedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(tip)

        // Update the TextView with the formatted tip (suppressing concatenation warning)
        binding.tipResult.text = getString(R.string.tip_amount) + " " + formattedTip
    }
}
