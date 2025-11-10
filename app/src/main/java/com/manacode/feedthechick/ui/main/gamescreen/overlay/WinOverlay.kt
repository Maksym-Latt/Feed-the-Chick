package com.manacode.feedthechick.ui.main.gamescreen.overlay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manacode.feedthechick.R
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.OrangePrimaryButton
import com.manacode.feedthechick.ui.main.component.SecondaryIconButton
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton

@Composable
fun WinOverlay(
    score: Int,
    onSupport: () -> Unit,
    onHome: () -> Unit
) {
    // ----------------------- Overlay -----------------------
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xaa000000)),
        contentAlignment = Alignment.Center
    ) {
        // ----------------------- Card -----------------------
        Column(
            modifier = Modifier
                .padding(24.dp)
                .padding(horizontal = 32.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ----------------------- Title -----------------------
            GradientOutlinedText(
                text = "GAME OVER",
                fontSize = 40.sp,
                gradientColors = listOf(Color(0xFFFFE3A1), Color(0xFFFF9D52))
            )

            // ----------------------- Chick -----------------------
            Image(
                painter = painterResource(id = R.drawable.chicken_win),
                contentDescription = null,
                modifier = Modifier.size(320.dp),
                contentScale = ContentScale.Fit
            )

            // ----------------------- Subtitle -----------------------
            GradientOutlinedText(
                text = "You feed $score seeds!",
                fontSize = 28.sp,
                gradientColors = listOf(Color(0xFFFFF4C2), Color(0xFFFFC66E))
            )

            // ----------------------- Buttons -----------------------
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                OrangePrimaryButton(
                    text = "Support",
                    modifier = Modifier.width(220.dp),
                    onClick = onSupport
                )
                StartPrimaryButton(
                    text = "MENU",
                    modifier = Modifier.width(220.dp),
                    onClick = onHome
                )
            }
        }
    }
}
