package eu.example.mycalc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.example.mycalc.ui.theme.DisplayColor
import eu.example.mycalc.ui.theme.orbitronBold

@Composable
fun Display(

) {
    val viewModel: CalcViewModel = viewModel()
    Row(
        Modifier
            .padding(10.dp)
            .shadow(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .fillMaxHeight(.4f)
            .background(DisplayColor),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = viewModel.secondaryDisplay.value,
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.3f),
                fontFamily = orbitronBold,
                fontSize = 30.sp,
                textAlign = TextAlign.End
            )
            Text(
                text = viewModel.primaryDisplay.value,
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                fontFamily = orbitronBold,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.End,
                lineHeight = 40.sp
            )
        }

    }
}

@Preview(
    showSystemUi = true, showBackground = true
)
@Composable
fun PrevDisplay(

) {
    Display()

}