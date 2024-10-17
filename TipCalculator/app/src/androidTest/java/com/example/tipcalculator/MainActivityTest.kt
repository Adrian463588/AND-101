package com.example.tipcalculator

import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import com.example.tipcalculator.databinding.ActivityMainBinding
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var binding: ActivityMainBinding

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            binding = activity.binding // Access the activity binding
        }
    }

    @Test
    fun calculateTip_withValidInput_noRounding() {
        scenario.onActivity { activity ->
            // Simulate entering a cost value
            binding.costOfService.setText("100")

            // Simulate selecting 20% tip
            val twentyPercentRadioButton = activity.findViewById<RadioButton>(R.id.option_twenty_percent)
            twentyPercentRadioButton.isChecked = true

            // Simulate turning off the round-up switch
            val roundUpSwitch = activity.findViewById<Switch>(R.id.round_up_switch)
            roundUpSwitch.isChecked = false

            // Perform the calculation
            binding.calculateButton.performClick()

            // Verify that the correct tip is calculated (100 * 0.20 = 20)
            val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(20.0)
            val resultTextView = activity.findViewById<TextView>(R.id.tip_result)
            assertEquals("Tip Amount $expectedTip", resultTextView.text)  // Removed the colon
        }
    }

    @Test
    fun calculateTip_withValidInput_withRounding() {
        scenario.onActivity { activity ->
            // Simulate entering a cost value
            binding.costOfService.setText("101.50")

            // Simulate selecting 18% tip
            val eighteenPercentRadioButton = activity.findViewById<RadioButton>(R.id.option_eighteen_percent)
            eighteenPercentRadioButton.isChecked = true

            // Simulate turning on the round-up switch
            val roundUpSwitch = activity.findViewById<Switch>(R.id.round_up_switch)
            roundUpSwitch.isChecked = true

            // Perform the calculation
            binding.calculateButton.performClick()

            // Verify that the correct tip is calculated and rounded up (101.50 * 0.18 = 18.27, rounded to 19)
            val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(19.0)
            val resultTextView = activity.findViewById<TextView>(R.id.tip_result)
            assertEquals("Tip Amount $expectedTip", resultTextView.text)  // Removed the colon
        }
    }

    @Test
    fun calculateTip_withInvalidInput_showsZeroTip() {
        scenario.onActivity { activity ->
            // Simulate entering an invalid cost value (empty string)
            binding.costOfService.setText("")

            // Perform the calculation
            binding.calculateButton.performClick()

            // Verify that the tip is 0.0
            val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(0.0)
            val resultTextView = activity.findViewById<TextView>(R.id.tip_result)
            assertEquals("Tip Amount $expectedTip", resultTextView.text)  // Removed the colon
        }
    }
}
