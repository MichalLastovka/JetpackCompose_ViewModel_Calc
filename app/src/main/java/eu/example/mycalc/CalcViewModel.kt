package eu.example.mycalc

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class CalcViewModel : ViewModel() {
    val secondaryDisplay = mutableStateOf("0")
    val primaryDisplay = mutableStateOf("")

    private fun tryInterimCalculation(expressionString: String = secondaryDisplay.value) {
        if (secondaryDisplay.value != "0") {
            try {
                val result = ExpressionBuilder(expressionString).build().evaluate()
                primaryDisplay.value = result.toString()
            } catch (ex: ArithmeticException) {
                println(ex)
                primaryDisplay.value = ""
            } catch (ex: IllegalArgumentException) {
                println(ex)
                primaryDisplay.value = ""
            }
        }else
            primaryDisplay.value = ""
    }

    fun makeFinaleCalculation(expressionString: String = secondaryDisplay.value) {
        try {
            val result = ExpressionBuilder(expressionString).build().evaluate()
            primaryDisplay.value = result.toString()
        } catch (ex: ArithmeticException) {
            println(ex)
            primaryDisplay.value = "Illegal operation"
        } catch (ex: IllegalArgumentException) {
            println(ex)
            primaryDisplay.value = "Check input"
        }
    }


    fun numberInput(number: String) {

        if (secondaryDisplay.value == "0" && secondaryDisplay.value.length == 1)
            secondaryDisplay.value = ""
        secondaryDisplay.value += number
        tryInterimCalculation()
    }

    fun decimalInput() {
        if (secondaryDisplay.value.last() != ('+') && secondaryDisplay.value.last() != ('-')
            && secondaryDisplay.value.last() != ('*') && secondaryDisplay.value.last() != ('/')
            && secondaryDisplay.value.last() != ('.') && secondaryDisplay.value.last() != ('%')
        )
            secondaryDisplay.value += "."
        tryInterimCalculation()
    }

    fun operatorInput(operator: String) {
        if (secondaryDisplay.value.last() != ('+') && secondaryDisplay.value.last() != ('-')
            && secondaryDisplay.value.last() != ('*') && secondaryDisplay.value.last() != ('/')
            && secondaryDisplay.value.last() != ('.') && secondaryDisplay.value.last() != ('%')
        )
            secondaryDisplay.value += operator
        tryInterimCalculation()
    }

    fun delete() {
        secondaryDisplay.value = secondaryDisplay.value.dropLast(1)
        if (secondaryDisplay.value.isBlank()) {
            secondaryDisplay.value = "0"
        }
        tryInterimCalculation()
    }

    fun erase() {
        secondaryDisplay.value = "0"
        primaryDisplay.value = ""
        tryInterimCalculation()
    }
}