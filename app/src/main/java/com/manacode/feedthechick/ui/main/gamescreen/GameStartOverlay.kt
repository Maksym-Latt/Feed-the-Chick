package com.manacode.eggmagnet.ui.main.gamescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.manacode.eggmagnet.ui.main.component.GradientOutlinedText
import androidx.compose.ui.unit.dp

@Composable
fun GameStartOverlay(
    onStart: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x99000000))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onStart() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { onStart() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientOutlinedText(
                text = "",
                fontSize = 26.sp,
                gradientColors = listOf(Color(0xFFB6FFDF), Color(0xFF19C58C))
            )
            Spacer(Modifier.height(6.dp))

            GradientOutlinedText(
                text = "",
                fontSize = 34.sp
            )
        }
    }
}