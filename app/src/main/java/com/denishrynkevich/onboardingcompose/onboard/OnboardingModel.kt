package com.denishrynkevich.onboardingcompose.onboard

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import com.denishrynkevich.onboardingcompose.R
import com.denishrynkevich.onboardingcompose.ui.theme.myPurple
import com.denishrynkevich.onboardingcompose.ui.theme.myRed
import com.denishrynkevich.onboardingcompose.ui.theme.myYellow

sealed class OnboardingModel (
    @DrawableRes val image : Int,
    val title: AnnotatedString,
    val description : String,
    val color: Color
) {
    data object FirstPage : OnboardingModel(
        image = R.drawable.img_car1,
        title = createAnnotatedString("Your first car without", "a driver's license"),
        description = "Goes to meet people who just got their license",
        color = myYellow
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.img_car2,
        title = createAnnotatedString("Always there: more than", "1000 cars in Tbilisi"),
        description = "Our company is a leader by the number of cars in the fleet",
        color = myPurple
    )

    data object ThirdPage : OnboardingModel(
        image = R.drawable.img_car3,
        title = createAnnotatedString("Do not pay for parking,", "maintenance and gasoline"),
        description = "We will pay for you, all expenses related to the car",
        color = myRed
    )

    companion object {
        fun createAnnotatedString(firstLine: String, secondLine: String): AnnotatedString {
            return buildAnnotatedString {
                append(firstLine)
                append("\n")
                append(secondLine)
            }
        }
    }
}