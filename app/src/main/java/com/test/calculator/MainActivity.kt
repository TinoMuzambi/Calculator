package com.test.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.d
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        var operation=minusButton.text
        var num1=0.0
        var ans=0.0
        var memory=0.0

        memClearButton.setOnClickListener {
            try {
                memory = 0.0
            }
            catch (e: Exception) {
                d("Tino Muzambi","memClearButton exception thrown.")
            }
        }

        memPlusButton.setOnClickListener {
            try {
                memory += outputTextView.text.toString().toDouble()
            }
            catch (e: Exception) {
                d("Tino Muzambi","memPlusButton exception thrown.")
            }
        }

        memMinusButton.setOnClickListener {
            try {
                memory -= outputTextView.text.toString().toDouble()
            }
            catch (e: Exception) {
                d("Tino Muzambi","memMinusButton exception thrown.")
            }
        }

        memRecallButton.setOnClickListener {
            try {
                answerTextView.text = memory.toString()
            }
            catch (e: Exception) {
                d("Tino Muzambi","memRecallButton exception thrown.")
            }
        }

        /**
         * @param button - Number button that has been clicked.
         * Method to process all the clicks
         * of the number buttons, 0-9
         */
        fun numButtonClick(button: Button) {
            try {
                var presentText = outputTextView.text
                presentText = presentText.toString()
                presentText += button.text
                outputTextView.text = presentText
            }
            catch (e: Exception) {
                d("Tino Muzambi","numButtonClick exception thrown.")
            }
        }

        /**
         * @param button - Operation button that has been clicked
         * Method to process all the clicks
         * of the operation buttons. +, -, / and *
         */
        fun operationClick(button: Button) {
            try {
                operation = button.text
                val teext = outputTextView.text.toString()
                when (operation) {
                    plusButton.text -> num1 = teext.toDouble()
                    minusButton.text -> num1 = teext.toDouble()
                    divideButton.text -> num1 = teext.toDouble()
                    multiplyButton.text -> num1 = teext.toDouble()
                    percentButton.text -> ans = teext.toDouble() / 100
                }
                numButtonClick(button)
            }
            catch (e: Exception) {
                d("Tino Muzambi","operationClick exception thrown.")
            }
        }

        plusButton.setOnClickListener {
            operationClick(plusButton)
        }

        decimalButton.setOnClickListener {
            numButtonClick(decimalButton)
        }

        minusButton.setOnClickListener {
            operationClick(minusButton)
        }

        divideButton.setOnClickListener {
            operationClick(divideButton)
        }

        multiplyButton.setOnClickListener {
            operationClick(multiplyButton)
        }

        percentButton.setOnClickListener {
            operationClick(percentButton)
        }

        equalsButton.setOnClickListener {
            try {
                when (operation) {
                    plusButton.text -> {
                        val textToCopy = outputTextView.text.toString()
                        val pos = textToCopy.indexOf("+")
                        val num2 = textToCopy.substring(pos + 1)
                        ans = num1 + num2.toDouble()
                    }
                    minusButton.text -> {
                        val textToCopy = outputTextView.text.toString()
                        val pos = textToCopy.indexOf("-")
                        val num2 = textToCopy.substring(pos + 1)
                        ans = num1 - num2.toDouble()
                    }
                    divideButton.text -> {
                        val textToCopy = outputTextView.text.toString()
                        val pos = textToCopy.indexOf(divideButton.text.toString())
                        val num2 = textToCopy.substring(pos + 1)
                        ans = num1 / num2.toDouble()
                    }
                    multiplyButton.text -> {
                        val textToCopy = outputTextView.text.toString()
                        val pos = textToCopy.indexOf(multiplyButton.text.toString())
                        val num2 = textToCopy.substring(pos + 1)
                        ans = num1 * num2.toDouble()
                    }
                }
                answerTextView.text = ans.toString()
            }
            catch (e: Exception) {
                d("Tino Muzambi","equalsButton exception thrown")
            }
        }

        eraseButton.setOnClickListener {
            try {
                var textString = outputTextView.text
                textString = textString.substring(0, textString.length - 1)
                outputTextView.text = textString
            }
            catch (e: Exception) {
                d("Tino Muzambi","eraseButton exception thrown.")
            }
        }

        clearButton.setOnClickListener {
            try {
                outputTextView.text = ""
                operation = minusButton.text
                num1 = 0.0
                ans = 0.0
                answerTextView.text = ""
            }
            catch (e: Exception) {
                d("Tino Muzambi","clearButton exceptinon thrown")
            }
        }

        sevenButton.setOnClickListener {
            numButtonClick(sevenButton)
        }

        eightButton.setOnClickListener {
            numButtonClick(eightButton)
        }

        nineButton.setOnClickListener {
            numButtonClick(nineButton)
        }

        fourButton.setOnClickListener {
            numButtonClick(fourButton)
        }

        fiveButton.setOnClickListener {
            numButtonClick(fiveButton)
        }

        sixButton.setOnClickListener {
            numButtonClick(sixButton)
        }

        oneButton.setOnClickListener {
            numButtonClick(oneButton)
        }

        twoButton.setOnClickListener {
            numButtonClick(twoButton)
        }

        threeButton.setOnClickListener {
            numButtonClick(threeButton)
        }

        zeroButton.setOnClickListener {
            numButtonClick(zeroButton)
        }

    }
}
