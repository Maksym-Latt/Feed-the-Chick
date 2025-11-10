package com.manacode.feedthechick.ui.main.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import kotlin.math.min

@Composable
fun FarmBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val skyHeight = size.height * 0.62f
        val groundHeight = size.height - skyHeight

        drawRect(
            brush = Brush.verticalGradient(
                0f to Color(0xFFFFF7D6),
                0.6f to Color(0xFFFFE4A8),
                1f to Color(0xFFFFD37F)
            ),
            size = Size(size.width, skyHeight)
        )

        drawRect(
            brush = Brush.verticalGradient(
                0f to Color(0xFFF6D483),
                1f to Color(0xFFE1B862)
            ),
            topLeft = Offset(0f, skyHeight),
            size = Size(size.width, groundHeight)
        )

        val sunRadius = min(size.width, skyHeight) * 0.18f
        drawCircle(
            color = Color(0xFFFFF2A6),
            radius = sunRadius,
            center = Offset(size.width * 0.82f, skyHeight * 0.25f)
        )
        drawCircle(
            color = Color(0x33FFF59D),
            radius = sunRadius * 1.7f,
            center = Offset(size.width * 0.82f, skyHeight * 0.25f)
        )

        val barnWidth = size.width * 0.22f
        val barnHeight = groundHeight * 0.58f
        val barnTop = skyHeight - barnHeight * 0.25f
        drawRoundRect(
            color = Color(0xFFD2554F),
            topLeft = Offset(size.width * 0.08f, barnTop),
            size = Size(barnWidth, barnHeight),
            cornerRadius = CornerRadius(24f, 24f)
        )
        drawRect(
            color = Color(0xFFB73F3B),
            topLeft = Offset(size.width * 0.08f, barnTop + barnHeight * 0.55f),
            size = Size(barnWidth, barnHeight * 0.45f)
        )
        val doorWidth = barnWidth * 0.42f
        val doorHeight = barnHeight * 0.55f
        drawRoundRect(
            color = Color(0xFFFBECD1),
            topLeft = Offset(size.width * 0.08f + (barnWidth - doorWidth) / 2f, barnTop + barnHeight - doorHeight),
            size = Size(doorWidth, doorHeight),
            cornerRadius = CornerRadius(18f, 18f)
        )

        val fenceHeight = groundHeight * 0.35f
        val fenceTop = size.height - fenceHeight - groundHeight * 0.1f
        val postWidth = size.width / 18f
        val postSpacing = postWidth * 1.15f
        var x = 0f
        while (x < size.width + postWidth) {
            drawRoundRect(
                color = Color(0xFFFFE3A4),
                topLeft = Offset(x, fenceTop),
                size = Size(postWidth, fenceHeight),
                cornerRadius = CornerRadius(12f, 12f)
            )
            x += postSpacing
        }
        drawRect(
            color = Color(0xFFF4C574),
            topLeft = Offset(0f, fenceTop + fenceHeight * 0.28f),
            size = Size(size.width, fenceHeight * 0.18f)
        )
        drawRect(
            color = Color(0xFFF4C574),
            topLeft = Offset(0f, fenceTop + fenceHeight * 0.65f),
            size = Size(size.width, fenceHeight * 0.16f)
        )

        drawIntoCanvas { canvas ->
            val cloudPaint = androidx.compose.ui.graphics.Paint().apply {
                color = Color(0xFFFFFFFF)
            }
            fun drawCloud(centerX: Float, centerY: Float, scaleFactor: Float) {
                canvas.save()
                canvas.translate(centerX, centerY)
                canvas.scale(scaleFactor, scaleFactor)
                canvas.drawCircle(Offset.Zero, 48f, cloudPaint)
                canvas.drawCircle(Offset(-34f, 12f), 36f, cloudPaint)
                canvas.drawCircle(Offset(34f, 12f), 36f, cloudPaint)
                canvas.drawCircle(Offset(-12f, -20f), 28f, cloudPaint)
                canvas.drawCircle(Offset(20f, -18f), 28f, cloudPaint)
                canvas.restore()
            }
            drawCloud(size.width * 0.25f, skyHeight * 0.32f, 1f)
            drawCloud(size.width * 0.55f, skyHeight * 0.18f, 0.9f)
            drawCloud(size.width * 0.68f, skyHeight * 0.4f, 1.1f)
        }

        val pathStart = skyHeight + groundHeight * 0.15f
        drawRoundRect(
            color = Color(0xFFE9C993),
            topLeft = Offset(size.width * 0.35f, pathStart),
            size = Size(size.width * 0.3f, groundHeight * 0.85f),
            cornerRadius = CornerRadius(180f, 180f)
        )

        val bushWidth = size.width * 0.18f
        val bushHeight = groundHeight * 0.32f
        fun drawBush(centerX: Float) {
            rotate(-2f, Offset(centerX, skyHeight + bushHeight / 1.2f)) {
                drawRoundRect(
                    color = Color(0xFF8BC34A),
                    topLeft = Offset(centerX - bushWidth / 2f, skyHeight + groundHeight * 0.05f),
                    size = Size(bushWidth, bushHeight),
                    cornerRadius = CornerRadius(80f, 80f)
                )
            }
        }
        drawBush(size.width * 0.72f)
        drawBush(size.width * 0.9f)
    }
}
