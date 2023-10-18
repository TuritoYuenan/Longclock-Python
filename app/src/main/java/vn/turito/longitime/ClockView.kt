package vn.turito.longitime

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
