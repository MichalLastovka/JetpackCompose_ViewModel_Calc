package eu.example.mycalc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.example.mycalc.ui.theme.EqualButtonColor
import eu.example.mycalc.ui.theme.EraseButtonColor

@Composable
fun Keyboard(

) {
    val viewModel: CalcViewModel = viewModel()
    Row(
        Modifier
            .padding(horizontal = 0.dp, vertical = 0.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top

    ) {
        Column(
            Modifier.padding(vertical = 10.dp, horizontal = 1.dp).fillMaxWidth(.2f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {}
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {}
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {}
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {}
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {}
        }
        Column(
            Modifier.padding(vertical = 10.dp, horizontal = 1.dp).fillMaxWidth(.25f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {}
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "7") {
                viewModel.numberInput("7")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "4") {
                viewModel.numberInput("4")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "1") {
                viewModel.numberInput("1")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "0") {
                viewModel.numberInput("0")
            }
        }
        Column(
            Modifier.padding(vertical = 10.dp, horizontal = 1.dp).fillMaxWidth(.33f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "/") {
                viewModel.operatorInput("/")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "8") {
                viewModel.numberInput("8")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "5") {
                viewModel.numberInput("5")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "2") {
                viewModel.numberInput("2")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = ".") {
                viewModel.decimalInput()
            }
        }
        Column(
            Modifier.padding(vertical = 10.dp, horizontal = 1.dp).fillMaxWidth(.5f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "*") {
                viewModel.operatorInput("*")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "9") {
                viewModel.numberInput("9")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "6") {
                viewModel.numberInput("6")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "3") {
                viewModel.numberInput("3")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "") {
                //viewModel.operatorInput("%")
            }
        }
        Column(
            Modifier.padding(vertical = 10.dp, horizontal = 1.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CalcButton(color = EraseButtonColor, modifier = Modifier.weight(.5f), text = "CE") {
                viewModel.erase()
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "⌫") {
                viewModel.delete()
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "-") {
                viewModel.operatorInput("-")
            }
            CalcButton(color = Color.LightGray, modifier = Modifier.weight(.5f), text = "+") {
                viewModel.operatorInput("+")
            }
            CalcButton(color = EqualButtonColor, modifier = Modifier.weight(.5f), text = "=") {
                viewModel.makeFinaleCalculation()
            }
        }
    }
}

@Preview
@Composable
fun PrevKeyboard(

) {
    Keyboard()
}