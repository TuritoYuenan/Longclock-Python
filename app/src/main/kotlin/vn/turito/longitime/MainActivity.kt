package vn.turito.longitime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import vn.turito.longitime.components.LongitimeBottomBar
import vn.turito.longitime.components.LongitimeTopBar
import vn.turito.longitime.theme.LongitimeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { LongitimeApp() }
	}
}

@Preview(showBackground = true)
@Composable
fun LongitimeApp(): Unit = LongitimeTheme {
	Scaffold(
		topBar = { LongitimeTopBar() },
		bottomBar = { LongitimeBottomBar() }
	) { paddingValues ->
		ClockView(paddingValues)
	}
}
