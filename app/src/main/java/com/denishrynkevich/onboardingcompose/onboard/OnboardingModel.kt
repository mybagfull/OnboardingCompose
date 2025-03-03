package com.denishrynkevich.onboardingcompose.onboard

import androidx.annotation.DrawableRes
import com.denishrynkevich.onboardingcompose.R

sealed class OnboardingModel (
    @DrawableRes val image : Int,
    val title: String,
    val description : String
) {
    data object FirstPage : OnboardingModel(
        image = R.drawable.img_car1,
        title = "Your first car without a driver's license",
        description = "Goes to meet people who just got their license"
    )
}