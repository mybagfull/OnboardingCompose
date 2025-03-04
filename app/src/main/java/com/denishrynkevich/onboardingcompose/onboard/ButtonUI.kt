package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.denishrynkevich.onboardingcompose.ui.theme.myYellow

@Composable
fun ButtonUi(
    text: String = ">",
    backgroundColor: Color = Color.White,
    textColor: Color = myYellow,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    fontSize: Int = 14,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor, contentColor = textColor
        ), shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = text, fontSize = fontSize.sp, style = textStyle
        )
    }


}


@Preview
@Composable
fun NextButton() {

    ButtonUi (text = ">") {

    }

}

@Preview
@Composable
fun SkipButton() {

    ButtonUi(text = "Skip",
        backgroundColor = Color.Transparent,
        textColor = Color.White.copy(alpha = 0.7f),
        textStyle = MaterialTheme.typography.labelSmall,
        fontSize = 18) {
    }


}