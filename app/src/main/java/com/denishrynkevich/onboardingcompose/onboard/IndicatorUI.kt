package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorUI(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color.White,
    unselectedColor: Color = Color.White.copy(alpha = 0.4f),
) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            repeat(pageSize) {
                Box(
                    modifier = Modifier
                        .height(8.dp)
                        .width(width = if (it == currentPage) 24.dp else 8.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = if (it == currentPage) selectedColor else unselectedColor)

                )
                Spacer(modifier = Modifier.size(if(it == 3) 0.dp else 8.dp))

            }

        }

}


@Preview(showBackground = false)
@Composable
fun IndicatorUIPreview1() {

    IndicatorUI(pageSize = 4, currentPage = 0)

}

@Preview(showBackground = false)
@Composable
fun IndicatorUIPreview2() {

        IndicatorUI(pageSize = 4, currentPage = 1)

}

@Preview(showBackground = false)
@Composable
fun IndicatorUIPreview3() {

        IndicatorUI(pageSize = 4, currentPage = 2)

}

@Preview(showBackground = false)
@Composable
fun IndicatorUIPreview4() {

        IndicatorUI(pageSize = 4, currentPage = 3)

}