package com.manacode.feedthechick.ui.main.gamescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton

@Composable
fun IntroOverlay(onStart: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xAA2C1505)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .background(Color(0xFFFFF4D2), shape = RoundedCornerShape(28.dp))
                .padding(horizontal = 32.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GradientOutlinedText(
                text = "Нагодуй курча!",
                fontSize = 30.sp,
                gradientColors = listOf(Color(0xFFFFF7C1), Color(0xFFFFC86B))
            )
            Text(
                text = "Перетягни зернятка у дзьобик і не дай курчаті з'їсти каміння чи жаб.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF704117),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp
                ),
                textAlign = TextAlign.Center
            )
            StartPrimaryButton(text = "Start", onClick = onStart)
        }
    }
}
