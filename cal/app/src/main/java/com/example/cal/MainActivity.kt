package com.example.cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etShowNumber: EditText
    private lateinit var buAC: Button
    private lateinit var buPlusMinus: Button
    private lateinit var buPer: Button
    private lateinit var buDiv: Button
    private lateinit var bu7: Button
    private lateinit var bu8: Button
    private lateinit var bu9: Button
    private lateinit var buMul: Button
    private lateinit var bu4: Button
    private lateinit var bu5: Button
    private lateinit var bu6: Button
    private lateinit var buSub: Button
    private lateinit var bu1: Button
    private lateinit var bu2: Button
    private lateinit var bu3: Button
    private lateinit var buSum: Button
    private lateinit var bu0: Button
    private lateinit var buDot: Button
    private lateinit var buEq: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etShowNumber = findViewById<EditText>(R.id.etShowNumber)
        buAC = findViewById<Button>(R.id.buAC)
        buPer = findViewById<Button>(R.id.buPer)
        buDiv = findViewById<Button>(R.id.buDiv)
        bu7 = findViewById<Button>(R.id.bu7)
        bu8 = findViewById<Button>(R.id.bu8)
        bu9 = findViewById<Button>(R.id.bu9)
        buMul = findViewById<Button>(R.id.buMul)
        bu4 = findViewById<Button>(R.id.bu4)
        bu5 = findViewById<Button>(R.id.bu5)
        bu6 = findViewById<Button>(R.id.bu6)
        buSub = findViewById<Button>(R.id.buSub)
        bu1 = findViewById<Button>(R.id.bu1)
        bu2 = findViewById<Button>(R.id.bu2)
        bu3 = findViewById<Button>(R.id.bu3)
        buSum = findViewById<Button>(R.id.buSum)
        bu0 = findViewById<Button>(R.id.bu0)
        buDot = findViewById<Button>(R.id.buDot)
        buEq = findViewById<Button>(R.id.buEq)

    }
    var isNewOp=true
    var dot=false

    fun buNumberEvent(view: View)
    {
        if(isNewOp)
        {
            etShowNumber.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buSelect.id)
        {
            bu0.id->
            {
                buClickValue+="0"
            }
            bu1.id->
            {
                buClickValue+="1"
            }
            bu2.id->
            {
                buClickValue+="2"
            }
            bu3.id->
            {
                buClickValue+="3"
            }
            bu4.id->
            {
                buClickValue+="4"
            }
            bu5.id->
            {
                buClickValue+="5"
            }
            bu6.id->
            {
                buClickValue+="6"
            }
            bu7.id->
            {
                buClickValue+="7"
            }
            bu8.id->
            {
                buClickValue+="8"
            }
            bu9.id->
            {
                buClickValue+="9"
            }
            buDot.id->
            {
                if(dot==false)
                {
                    buClickValue += "."
                }
                dot=true
            }
            buPlusMinus.id->
            {
                buClickValue="-" + buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }
    var op="X"
    var oldNumber=""

    fun buOpEvent(view: View)
    {
        val buSelect= view as Button
        when(buSelect.id)
        {
            buMul.id->
            {
                op="X"
            }
            buDiv.id->
            {
                op="÷"
            }
            buSub.id->
            {
                op="-"
            }
            buSum.id->
            {
                op="+"
            }
        }
        oldNumber=etShowNumber.text.toString()
        isNewOp=true
        dot=false
    }

    fun buEqualEvent(view: View)
    {
        val newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "X"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View)
    {
        val number=(etShowNumber.text.toString().toDouble())/100
        etShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View)
    {
        etShowNumber.setText("0")
        isNewOp=true
        dot=false
    }
}