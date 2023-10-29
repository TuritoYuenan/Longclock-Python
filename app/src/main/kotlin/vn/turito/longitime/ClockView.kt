package vn.turito.longitime

import android.os.Build
import android.widget.TextClock
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Preview
@Composable
fun CustomView() {
	AndroidView(
		modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
		factory = { context -> TextClock(context) }
	)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClockView(pad: PaddingValues) = Column(Modifier.padding(pad)) {
	val clock = LocalDateTime.now()
	val clockFormat = DateTimeFormatter.ofPattern("HH:mm")

	Text(
		clock.format(clockFormat),
		Modifier.fillMaxWidth(),
		textAlign = TextAlign.Center,
		style = TextStyle(
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight.Black,
			fontSize = 100.sp,
		)
	)
}
