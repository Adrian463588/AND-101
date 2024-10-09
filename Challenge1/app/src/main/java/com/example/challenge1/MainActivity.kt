package com.example.challenge1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextView components for each pattern
        val pyramidTextView = findViewById<TextView>(R.id.pyramidPattern)
        val invertedPyramidTextView = findViewById<TextView>(R.id.invertedPyramidPattern)
        val diamondTextView = findViewById<TextView>(R.id.diamondPattern)
        val xPatternTextView = findViewById<TextView>(R.id.xPattern)
        val hollowPyramidTextView = findViewById<TextView>(R.id.hollowPyramidPattern)

        // Setting patterns to TextViews
        pyramidTextView.text = generatePyramidPattern(5)
        invertedPyramidTextView.text = generateInvertedPyramidPattern(5)
        diamondTextView.text = generateDiamondPattern(5)
        xPatternTextView.text = generateXPattern(7)
        hollowPyramidTextView.text = generateHollowPyramidPattern(5)
    }

    // Function to generate a pyramid star pattern
    private fun generatePyramidPattern(rows: Int): String {
        val result = StringBuilder()
        for (i in 1..rows) {
            result.append(" ".repeat(rows - i))
            result.append("*".repeat(2 * i - 1))
            result.append("\n")
        }
        return result.toString()
    }

    // Function to generate an inverted pyramid star pattern
    private fun generateInvertedPyramidPattern(rows: Int): String {
        val result = StringBuilder()
        for (i in rows downTo 1) {
            result.append(" ".repeat(rows - i))
            result.append("*".repeat(2 * i - 1))
            result.append("\n")
        }
        return result.toString()
    }

    // Function to generate a diamond (kite) star pattern
    private fun generateDiamondPattern(rows: Int): String {
        val result = StringBuilder()
        // Upper pyramid
        for (i in 1..rows) {
            result.append(" ".repeat(rows - i))
            result.append("*".repeat(2 * i - 1))
            result.append("\n")
        }
        // Lower inverted pyramid
        for (i in rows - 1 downTo 1) {
            result.append(" ".repeat(rows - i))
            result.append("*".repeat(2 * i - 1))
            result.append("\n")
        }
        return result.toString()
    }

    // Function to generate an X star pattern
    private fun generateXPattern(size: Int): String {
        val result = StringBuilder()
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (i == j || i + j == size - 1) {
                    result.append("*")
                } else {
                    result.append(" ")
                }
            }
            result.append("\n")
        }
        return result.toString()
    }

    // Function to generate a hollow pyramid star pattern
    private fun generateHollowPyramidPattern(rows: Int): String {
        val result = StringBuilder()
        for (i in 1..rows) {
            for (j in 1..(rows - i)) {
                result.append(" ")
            }
            for (k in 1..(2 * i - 1)) {
                if (k == 1 || k == 2 * i - 1 || i == rows) {
                    result.append("*")
                } else {
                    result.append(" ")
                }
            }
            result.append("\n")
        }
        return result.toString()
    }
}