package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinished: () -> Unit) {

    val pages = listOf(OnboardingModel.FirstPage, OnboardingModel.SecondPage, OnboardingModel.ThirdPage, OnboardingModel.FourthPage)

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    var currentColor by remember { mutableStateOf(pages[pagerState.currentPage].color) }

    currentColor = pages[pagerState.currentPage].color



    Scaffold (
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp, 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage)
                SkipButton(text = "Skip",
                    backgroundColor = Color.Transparent,
                    textColor = Color.White.copy(alpha = 0.7f),
                    textStyle = MaterialTheme.typography.labelSmall,
                    fontSize = 18.sp) {}
                NextButton(iconColor = currentColor, backgroundColor = Color.White, currentStep = pagerState.currentPage, totalSteps = pages.size) {
                }

            }
        }
    ,
    content = {
        Column(Modifier.padding(it)) {
            HorizontalPager(
                state = pagerState
            ) { index ->
                OnboardingGraphUI(onboardingModel = pages[index])
            }
        }
    }
        ,
        containerColor = currentColor
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen {
    }
}