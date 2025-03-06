package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinished: () -> Unit) {

    val pages = remember {
        listOf(
            OnboardingModel.FirstPage,
            OnboardingModel.SecondPage,
            OnboardingModel.ThirdPage,
            OnboardingModel.FourthPage
        )
    }

    val pagerState = rememberPagerState(initialPage = 1) {
        pages.size
    }

    val currentColor by remember(pagerState.currentPage) {
        derivedStateOf {
            pages[pagerState.currentPage].color
        }
    }

    val scope = rememberCoroutineScope()

    Scaffold (
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.offset(y = (8.dp))) {
                    IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage)
                    SkipButton(text = "Skip",
                        backgroundColor = Color.Transparent,
                        textColor = Color.White.copy(alpha = 0.7f),
                        textStyle = MaterialTheme.typography.labelSmall,
                        fontSize = 18.sp) {
                        scope.launch {
                            onFinished()
                        }
                    }
                }

                NextButton(iconColor = currentColor, backgroundColor = Color.White, currentStep = pagerState.currentPage, totalSteps = pages.size) {
                    scope.launch { if (pagerState.currentPage < pages.size - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        onFinished()
                    } }

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