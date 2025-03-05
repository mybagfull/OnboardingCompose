package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingGraphUI(onboardingModel: OnboardingModel) {
    val descriptionColor = Color.White.copy(alpha = 0.9f)
    Surface(
        color = onboardingModel.color,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(35.dp)
            )

            Text(
                text = onboardingModel.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp, end = 80.dp),
                fontSize = 28.sp,
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.titleMedium.copy(lineHeight = 32.sp),
                color = Color.White
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(15.dp)
            )

            Text(
                text = onboardingModel.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp, end = 80.dp),
                fontSize = 18.sp,
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 24.sp),
                color = descriptionColor,
            )

            Spacer(
                modifier = Modifier.size(20.dp)
            )

            Image(
                painter = painterResource(id = onboardingModel.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp)
                    .aspectRatio(0.8741F),
                alignment = Alignment.Center
            )
        }
    }


}


@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(OnboardingModel.FirstPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(OnboardingModel.SecondPage)
}