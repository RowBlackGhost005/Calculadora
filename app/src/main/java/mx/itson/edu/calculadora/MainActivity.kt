package mx.itson.edu.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn0:Button = findViewById(R.id.btn0)
        val btn1:Button = findViewById(R.id.btn1)
        val btn2:Button = findViewById(R.id.btn2)
        val btn3:Button = findViewById(R.id.btn3)
        val btn4:Button = findViewById(R.id.btn4)
        val btn5:Button = findViewById(R.id.btn5)
        val btn6:Button = findViewById(R.id.btn6)
        val btn7:Button = findViewById(R.id.btn7)
        val btn8:Button = findViewById(R.id.btn8)
        val btn9:Button = findViewById(R.id.btn9)
        val btnPlus:Button = findViewById(R.id.btnPlus)
        val btnMinus:Button = findViewById(R.id.btnMinus)
        val btnMultiply:Button = findViewById(R.id.btnMultiply)
        val btnDivide:Button = findViewById(R.id.btnDivide)
        val btnCalculate:Button = findViewById(R.id.btnCalculate)
        val btnDelete:Button = findViewById(R.id.btnDelete)
        var tvResult:TextView = findViewById(R.id.tvResult)
        var tvInput:TextView = findViewById(R.id.tvInput)

        var currentResult:Float = 0f

        var currentOperation:String = ""

        btn0.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "0")

        }

        btn1.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "1")
        }

        btn2.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "2")
        }

        btn3.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "3")
        }

        btn4.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "4")
        }

        btn5.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "5")
        }

        btn6.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "6")
        }

        btn7.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "7")
        }

        btn8.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "8")
        }

        btn9.setOnClickListener{
            tvInput.setText(tvInput.text.toString() + "9")
        }

        btnDelete.setOnClickListener{
            tvInput.setText("")
            tvResult.setText("")
            currentResult = 0f
        }

        btnCalculate.setOnClickListener{


            if(currentOperation == "plus"){
                currentResult = currentResult + tvInput.text.toString().toInt()
            }

            if(currentOperation == "minus"){
                currentResult = currentResult - tvInput.text.toString().toInt()
            }

            if(currentOperation == "multiply"){
                currentResult = currentResult * tvInput.text.toString().toInt()
            }

            if(currentOperation == "divide"){
                currentResult = currentResult / tvInput.text.toString().toInt()
            }

            tvResult.setText(currentResult.toString())
            tvInput.setText("")
            currentOperation = ""
        }

        btnPlus.setOnClickListener{
            tvResult.setText(tvInput.text.toString() + "+")

            var userInput:Int = tvInput.text.toString().toInt()

            currentResult = currentResult + userInput



            tvInput.setText("")

            currentOperation = "plus"
        }

        btnMinus.setOnClickListener{
            tvResult.setText(tvInput.text.toString() + "-")

            var userInput:Int = tvInput.text.toString().toInt()

            currentResult = currentResult - userInput

            tvInput.setText("")

            currentOperation = "minus"
        }

        btnMultiply.setOnClickListener{
            tvResult.setText(tvInput.text.toString() + "*")

            var userInput:Int = tvInput.text.toString().toInt()

            currentResult = currentResult * userInput

            tvInput.setText("")

            currentOperation = "multiply"
        }

        btnDivide.setOnClickListener{
            tvResult.setText(tvInput.text.toString() + "/")

            var userInput:Int = tvInput.text.toString().toInt()

            currentResult = currentResult / userInput

            tvInput.setText("")

            currentOperation = "divide"
        }
    }
}