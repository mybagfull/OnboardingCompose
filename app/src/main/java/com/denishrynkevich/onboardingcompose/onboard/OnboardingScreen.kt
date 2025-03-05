package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinished: () -> Unit) {

    val pages = listOf(OnboardingModel.FirstPage, OnboardingModel.SecondPage, OnboardingModel.ThirdPage, OnboardingModel.FourthPage)

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    HorizontalPager(state = pagerState) { index ->
        OnboardingGraphUI(onboardingModel = pages[index])
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen {
    }
}