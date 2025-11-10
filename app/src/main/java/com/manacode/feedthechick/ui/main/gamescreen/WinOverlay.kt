package com.manacode.feedthechick.ui.main.gamescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.SecondaryIconButton
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton

@Composable
fun WinOverlay(
    score: Int,
    onRetry: () -> Unit,
    onHome: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xAA0A3A12)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .background(Color(0xFFFFF4D2), shape = androidx.compose.foundation.shape.RoundedCornerShape(28.dp))
                .padding(horizontal = 32.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GradientOutlinedText(
                text = "Перемога!",
                fontSize = 30.sp,
                gradientColors = listOf(Color(0xFFFFF7C1), Color(0xFFFFC86B))
            )
            Text(
                text = "Corn fed: $score",
                style = MaterialTheme.typography.titleMedium.copy(color = Color(0xFF704117))
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                StartPrimaryButton(text = "Retry", onClick = onRetry)
                SecondaryIconButton(onClick = onHome, modifier = Modifier.size(52.dp)) {
                    Icon(Icons.Default.Home, contentDescription = "Home", tint = Color(0xFF704117))
                }
            }
        }
    }
}
