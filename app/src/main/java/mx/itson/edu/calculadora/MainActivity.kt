package mx.itson.edu.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var currentResult:Float = 0.0F

    var currentOperation:String = "plus"

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
            currentOperation = "plus"
            currentResult = 0F
        }

        btnCalculate.setOnClickListener{

            clearBackOperation()

            tvResult.setText(currentResult.toString())
            tvInput.setText("")
            currentOperation = ""
        }

        btnPlus.setOnClickListener{
            if(currentOperation != "plus"){
                clearBackOperation()
            }


            var userInput: Float = 0f

            if (currentResult != 0f) {
                tvResult.setText(currentResult.toString() + " + ")

                if (!tvInput.text.toString().isBlank()) {
                    userInput = tvInput.text.toString().toFloat()
                    tvResult.setText(currentResult.toString() + " + " + tvInput.text.toString() + " + ")
                }

                currentResult = currentResult + userInput

            } else if(!tvInput.text.toString().isBlank()){
                tvResult.setText(tvInput.text.toString() + " + ")
                currentResult = tvInput.text.toString().toFloat()
            }

            tvInput.setText("")

            currentOperation = "plus"

        }

        btnMinus.setOnClickListener{
            if(currentOperation != "minus"){
                clearBackOperation()
            }

            var userInput: Float = 0f



            if (currentResult != 0f) {
                tvResult.setText(currentResult.toString() + " - ")

                if (!tvInput.text.toString().isBlank()) {
                    userInput = tvInput.text.toString().toFloat()
                    tvResult.setText(currentResult.toString() + " - " + tvInput.text.toString() + " - ")
                }

                currentResult = currentResult - userInput

            } else if(!tvInput.text.toString().isBlank()){
                tvResult.setText(tvInput.text.toString() + " - ")
                currentResult -= tvInput.text.toString().toFloat()
            }

            tvInput.setText("")

            currentOperation = "minus"
        }

        btnMultiply.setOnClickListener{
            if(currentOperation != "multiply"){
                clearBackOperation()
            }

            var userInput:Float = 0f

            if(tvInput.text.isNotBlank()){

                userInput = tvInput.text.toString().toFloat()


                tvResult.text = "$currentResult * "

                if (tvInput.text.toString().isNotBlank()) {
                    userInput = tvInput.text.toString().toFloat()
                    tvResult.setText(currentResult.toString() + " * " + tvInput.text.toString() + " * ")
                }else{
                    currentResult *= userInput

                    tvResult.text = "$currentResult * "
                }

                currentResult *= userInput


            }else{
                tvResult.text = "$currentResult * "
            }


/*
            var userInput: Float = 0f

            if (currentResult != 0.0f) {
                tvResult.setText(currentResult.toString() + " * ")

                if (!tvInput.text.toString().isBlank()) {
                    userInput = tvInput.text.toString().toFloat()
                    tvResult.setText(currentResult.toString() + " * " + tvInput.text.toString() + " * ")
                }

                currentResult = currentResult * userInput

            } else if(!tvInput.text.toString().isBlank()){
                tvResult.setText(tvInput.text.toString() + " * ")
                currentResult = tvInput.text.toString().toFloat()
            }


 */
            tvInput.setText("")

            currentOperation = "multiply"


        }

        btnDivide.setOnClickListener{
            if(currentOperation != "divide"){
                clearBackOperation()
            }

            var userInput:Float = 0f

            if(tvInput.text.isNotBlank()){

                userInput = tvInput.text.toString().toFloat()

                    if(userInput == 0F){
                        tvResult.text = "Can't Divide by 0"
                    }

                    tvResult.text = "$currentResult / "

                    if (tvInput.text.toString().isNotBlank()) {
                        tvResult.setText(currentResult.toString() + " / " + tvInput.text.toString() + " / ")
                    } else {
                        currentResult /= userInput

                        tvResult.text = "$currentResult / "
                    }

                    currentResult /= userInput

            }else{
                tvResult.text = "$currentResult / "
            }

            tvInput.setText("")

            currentOperation = "divide"
        }
    }

    fun clearBackOperation(){

        var tvResult:TextView = findViewById(R.id.tvResult)
        var tvInput:TextView = findViewById(R.id.tvInput)

        if(currentOperation == "plus" && !tvInput.text.toString().isBlank()){
            currentResult = currentResult + tvInput.text.toString().toInt()
        }

        if(currentOperation == "minus" && !tvInput.text.toString().isBlank()){
            currentResult = currentResult - tvInput.text.toString().toInt()
        }

        if(currentOperation == "multiply" && tvInput.text.toString().isNotBlank()){
            currentResult = currentResult * tvInput.text.toString().toInt()
        }

        if(currentOperation == "divide" && !tvInput.text.toString().isBlank()){
            if(tvInput.text.toString().toInt() != 0) {
                currentResult = currentResult / tvInput.text.toString().toInt()
            }
        }

        tvInput.text = ""

        currentOperation = ""

    }
}