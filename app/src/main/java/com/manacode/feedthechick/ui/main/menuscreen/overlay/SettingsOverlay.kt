package com.manacode.feedthechick.ui.main.menuscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.GradientOutlinedTextShort
import com.manacode.feedthechick.ui.main.component.OrangePrimaryButton
import com.manacode.feedthechick.ui.main.component.SecondaryBackButton
import com.manacode.feedthechick.ui.main.settings.SettingsViewModel

@Composable
fun SettingsOverlay(
    onClose: () -> Unit,
    onPrivacy: () -> Unit = {},
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val ui by viewModel.ui.collectAsStateWithLifecycle()
    val cardShape = RoundedCornerShape(18.dp)

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0x99000000))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClose() }
    ) {
        SecondaryBackButton(
            onClick = onClose,
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp),
        )

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .width(300.dp)
                .clip(cardShape)
                .background(Color(0xFFE6FAFF))
                .border(2.dp, Color(0xFF10829A), cardShape)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {}
                .padding(vertical = 24.dp, horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GradientOutlinedText(
                    text = "Settings",
                    fontSize = 28.sp,
                    gradientColors = listOf(Color.White, Color.White)
                )

                Spacer(Modifier.height(16.dp))

                SettingSwitchRow(
                    title = "Music",
                    checked = ui.musicVolume > 0,
                    onCheckedChange = viewModel::setMusicEnabled
                )

                Spacer(Modifier.height(12.dp))

                SettingSwitchRow(
                    title = "Sound",
                    checked = ui.soundVolume > 0,
                    onCheckedChange = viewModel::setSoundEnabled
                )

                Spacer(Modifier.height(28.dp))

                OrangePrimaryButton(
                    text = "Privacy Policy",
                    onClick = onPrivacy,
                    modifier = Modifier.fillMaxWidth(0.85f)
                )
            }
        }
    }
}

@Composable
private fun SettingSwitchRow(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    val shape = RoundedCornerShape(16.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color(0xFFECFDFF))
            .border(1.dp, Color(0xFF93E9F6), shape)
            .padding(horizontal = 18.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            GradientOutlinedTextShort(
                text = title,
                fontSize = 20.sp,
                gradientColors = listOf(Color(0xFF132E35), Color(0xFF132E35)),
                horizontalPadding = 0.dp
            )
            Text(
                text = if (checked) "Enabled" else "Muted",
                color = Color(0xFF0E3E49),
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(Modifier.width(12.dp))

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF00C4A2),
                checkedTrackColor = Color(0xFF8CFFE9),
                uncheckedThumbColor = Color(0xFF8CA9B0),
                uncheckedTrackColor = Color(0xFFC7E3E8)
            )
        )
    }
}
