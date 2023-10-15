package vn.turito.longitime

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import vn.turito.longitime.components.NavBar
import vn.turito.longitime.theme.LongitimeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { LongitimeApp() }
	}
}

@Preview(
	name = "Dark mode",
	uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun LongitimeApp() {
	LongitimeTheme {
		Scaffold(
			bottomBar = { NavBar() }
		) { paddingValues ->
			Column(Modifier.padding(paddingValues)) {
				Text(
					"12:45",
					Modifier.fillMaxWidth(),
					style = clockFace
				)
			}
		}
	}
}

val clockFace: TextStyle
	get() = TextStyle(
		color = MaterialTheme.colorScheme.onBackground,
		textAlign = TextAlign.Center,
		fontWeight = FontWeight.Black,
		fontSize = 50.sp,
	)
