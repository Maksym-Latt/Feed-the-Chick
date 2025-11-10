package com.manacode.feedthechick.ui.main.menuscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manacode.feedthechick.ui.main.component.FarmBackground
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton

@Composable
fun MenuScreen(
    onStartGame: () -> Unit,
    lastScore: Int?
) {
    Box(modifier = Modifier.fillMaxSize()) {
        FarmBackground(modifier = Modifier.matchParentSize())

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 48.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoTitle()

            Spacer(modifier = Modifier.height(32.dp))

            StartPrimaryButton(
                text = "Play",
                onClick = onStartGame,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Потягни зернятка до курчати та бережи його від каміння й жаб!",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF8C5A2E),
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                ),
                textAlign = TextAlign.Center
            )

            if (lastScore != null) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Минулого разу: $lastScore зернят",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF6D3B1A),
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}

@Composable
private fun LogoTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFFFFF176), Color(0xFFFFD54F), Color(0xFFFFB300)),
                            radius = 100f
                        ),
                        shape = MaterialTheme.shapes.large
                    )
            )
            GradientOutlinedText(
                text = "Feed the Chick",
                fontSize = 42.sp,
                gradientColors = listOf(Color(0xFFFFF4C2), Color(0xFFFFC66E))
            )
        }

        Text(
            text = "Двір ферми чекає на турботливого гравця!",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFF8C5A2E),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}
