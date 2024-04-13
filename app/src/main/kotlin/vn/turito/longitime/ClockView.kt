package vn.turito.longitime

import android.widget.TextClock
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Preview
@Composable
fun ClockView(pad: PaddingValues) = Column(Modifier.padding(pad)) {
	AndroidView(
		factory = { context ->
			TextClock(context).apply {
				format24Hour?.let { this.format24Hour = "HH:MM:SS" }
				timeZone?.let { this.timeZone = it }
				textSize.let { this.textSize = 30f }
			}
		}
	)
}
