package vn.turito.longitime

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
import vn.turito.longitime.components.LTimeBottomBar
import vn.turito.longitime.components.LTimeTopBar
import vn.turito.longitime.theme.LTimeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { LongitimeApp() }
	}
}

@Preview(showBackground = true)
@Composable
fun LongitimeApp(): Unit = LTimeTheme {
	Scaffold(
		topBar = { LTimeTopBar() },
		bottomBar = { LTimeBottomBar() }
	) { paddingValues ->
		Column(Modifier.padding(paddingValues)) {
			Text(
				"12:45",
				Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center,
				style = TextStyle(
					color = MaterialTheme.colorScheme.onBackground,
					fontWeight = FontWeight.Black,
					fontSize = 100.sp,
				)
			)
		}
	}
}
