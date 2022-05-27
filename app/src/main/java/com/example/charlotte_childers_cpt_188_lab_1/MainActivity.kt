package com.example.charlotte_childers_cpt_188_lab_1
//    Charlotte Childers CPT-188 Lab One
//    5/28/2022
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    //Declaration of Variables
    lateinit var firstNum: EditText;
    lateinit var secondNum: EditText;
    lateinit var calculate: Button;
    lateinit var res: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Begin working with variables
        firstNum = findViewById(R.id.etNum1)
        secondNum = findViewById(R.id.etNum2)
        calculate = findViewById(R.id.btnCalculate)
        res = findViewById(R.id.txtResult)
        //ID assigned to variables


        // Error toast
        val text = "There was an error in your computations!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()



        calculate.setOnClickListener {
            try {
                val numInputOne = firstNum.text.toString().toInt()
                val numInputTwo = secondNum.text.toString().toInt()
                val finalResult = numInputOne + numInputTwo
                res.isVisible = true
                res.setText("Result: $finalResult")


            } catch (e: Exception) {
                Toast.makeText(applicationContext, text, duration).show()
            }finally {
                closeKeyBoard()
            }



        }

    }

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}
