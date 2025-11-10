package com.manacode.feedthechick.ui.main.gamescreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manacode.feedthechick.R
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.GradientOutlinedTextShort
import com.manacode.feedthechick.ui.main.component.OrangePrimaryButton
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton

@Composable
fun WinOverlay(
    totalPoints: Int,
    gainedPoints: Int,
    onOpenMagnetShop: () -> Unit,
    onPlayAgain: () -> Unit,
    onMenu: () -> Unit,
    @DrawableRes chickenRes: Int = R.drawable.ic_launcher_foreground
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xcd000000))
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(top = 56.dp, end = 24.dp, start = 24.dp),
            horizontalAlignment = Alignment.End
        ) {
            NonClickableOrangeBadge(
                text = "${totalPoints.thousands()} points"
            )
            Spacer(Modifier.height(4.dp))
            GradientOutlinedTextShort(
                text = formatDelta(gainedPoints),
                fontSize = 18.sp,
                textAlign = TextAlign.End
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientOutlinedText(
                text = "WIN!!!",
                fontSize = 46.sp
            )

            Spacer(Modifier.height(10.dp))

            Image(
                painter = painterResource(chickenRes),
                contentDescription = "Winning chicken",
                modifier = Modifier
                    .fillMaxWidth(0.73f)
                    .wrapContentHeight(),
                contentScale = ContentScale.Fit
            )

            Spacer(Modifier.height(12.dp))

            GradientOutlinedText(
                text = "${formatDelta(gainedPoints)} points",
                fontSize = 30.sp
            )

            Spacer(Modifier.height(18.dp))

            OrangePrimaryButton(
                text = "Update magnet",
                onClick = onOpenMagnetShop,
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            Spacer(Modifier.height(14.dp))

            OrangePrimaryButton(
                text = "Play again",
                onClick = onPlayAgain,
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            Spacer(Modifier.height(18.dp))

            StartPrimaryButton(
                text = "MENU",
                onClick = onMenu,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }
    }
}

/* ---------- Вспомогалки ---------- */

@Composable
internal fun NonClickableOrangeBadge(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        OrangePrimaryButton(text = text, onClick = {})
        Box(
            Modifier
                .matchParentSize()
                .pointerInput(Unit) {
                    awaitPointerEventScope { while (true) awaitPointerEvent() }
                }
        )
    }
}

internal fun Int.thousands(): String = "%,d".format(this).replace(',', ' ')

internal fun formatDelta(v: Int): String = if (v >= 0) "+$v" else v.toString()