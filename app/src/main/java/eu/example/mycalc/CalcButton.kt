package eu.example.mycalc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.example.mycalc.ui.theme.orbitronBold

@Composable
fun CalcButton(
    color: Color, modifier: Modifier, text: String, onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier
            .clip(RoundedCornerShape(2.dp))
            .fillMaxWidth()
            .background(color)
            .shadow(1.5.dp)
            .then(modifier)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            fontFamily = orbitronBold
        )
    }
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun PrevCalcButton(

) {
    CalcButton(color = Color.LightGray, modifier = Modifier, text = "1") {

    }
}
