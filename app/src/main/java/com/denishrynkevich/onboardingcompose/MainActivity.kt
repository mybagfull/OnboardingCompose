package com.denishrynkevich.onboardingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.denishrynkevich.onboardingcompose.ui.theme.OnboardingComposeTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.denishrynkevich.onboardingcompose.onboard.OnboardingScreen
import com.denishrynkevich.onboardingcompose.onboard.OnboardingUtils
import com.denishrynkevich.onboardingcompose.ui.theme.myBlue
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            OnboardingComposeTheme {

                Surface(color = myBlue) {
                    if (onboardingUtils.isOnboardingCompleted()) {
                        ShowHomeScreen()
                    } else {
                        ShowOnboardingScreen()

                    }
                }

            }
        }
    }

    @Composable
    private fun ShowHomeScreen() {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()){
            Text(
                text = "You are a clever person!"
                , style = MaterialTheme.typography.titleMedium
                , fontSize = 28.sp
                , color = Color.White
                , textAlign = TextAlign.Center)
        }


    }

    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    ShowHomeScreen()
                }
            }
        }


    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        OnboardingComposeTheme {
        }
    }
}

