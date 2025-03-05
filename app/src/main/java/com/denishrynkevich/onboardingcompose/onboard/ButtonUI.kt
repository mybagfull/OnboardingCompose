package com.denishrynkevich.onboardingcompose.onboard

import androidx.compose.animation.core.tween
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.denishrynkevich.onboardingcompose.ui.theme.myYellow
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.denishrynkevich.onboardingcompose.R

@Composable
fun SkipButton(
    text: String = ">",
    backgroundColor: Color = Color.White,
    textColor: Color = myYellow,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    fontSize: TextUnit = 18.sp,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor, contentColor = textColor
        )
    ) {
        Text(
            text = text, fontSize = fontSize, style = textStyle, modifier = Modifier.offset(x = (-25).dp)
        )
    }


}

@Composable
fun NextButton(
    currentStep: Int,
    totalSteps: Int,
    backgroundColor: Color = Color.White,
    iconColor: Color = Color.Yellow,
    onClick: () -> Unit
) {
    val progress = animateFloatAsState(
        targetValue = currentStep.toFloat() / totalSteps.toFloat(),
        animationSpec = tween(durationMillis = 500)
    ).value

    Box(
        modifier = Modifier
            .size(58.dp)
            .padding(0.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .clip(CircleShape)
                .size(58.dp)
                .alpha(0.8f)) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_arrow),
                contentDescription = "Следующий экран",
                tint = iconColor
            )
        }
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = 3.dp.toPx()
            val radius = size.minDimension / 2 - strokeWidth / 2
            val center = Offset(size.width / 2, size.height / 2)

            // Круг внутри
            drawCircle(
                color = backgroundColor.copy(alpha = 0.4f),
                radius = size.minDimension / 2 - 16.dp.toPx() / 2,
                center = center
            )

            // Внешняя окружность
            drawCircle(
                color = backgroundColor.copy(alpha = 0.4f),
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth)
            )

            // Заполнение внешней окружности
            drawArc(
                color = backgroundColor,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Square),
                topLeft = center - Offset(radius, radius),
                size = androidx.compose.ui.geometry.Size(radius * 2, radius * 2)
            )
        }
    }

}


@Preview
@Composable
fun NextButtonPreview() {

    NextButton (backgroundColor = Color.White, currentStep = 1, totalSteps = 4) {

    }

}

@Preview
@Composable
fun SkipButtonPreview() {
    SkipButton(text = "Skip",
        backgroundColor = Color.Transparent,
        textColor = Color.White.copy(alpha = 0.7f),
        textStyle = MaterialTheme.typography.labelSmall,
        fontSize = 18.sp) {
    }
}