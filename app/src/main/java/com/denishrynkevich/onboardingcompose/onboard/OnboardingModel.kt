package com.denishrynkevich.onboardingcompose.onboard

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.denishrynkevich.onboardingcompose.R
import com.denishrynkevich.onboardingcompose.ui.theme.myPurple
import com.denishrynkevich.onboardingcompose.ui.theme.myYellow

sealed class OnboardingModel (
    @DrawableRes val image : Int,
    val title: String,
    val description : String,
    val color: Color
) {
    data object FirstPage : OnboardingModel(
        image = R.drawable.img_car1,
        title = "Your first car without a driver's license",
        description = "Goes to meet people who just got their license",
        color = myYellow
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.img_car2,
        title = "Always there: more than 1000 cars in Tbilisi",
        description = "Our company is a leader by the number of cars in the fleet",
        color = myPurple
    )
}