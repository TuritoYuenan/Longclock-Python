package vn.turito.longitime

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import vn.turito.longitime.components.LTimeBottomBar
import vn.turito.longitime.components.LTimeTopBar
import vn.turito.longitime.theme.LTimeTheme

class MainActivity : ComponentActivity() {
	@RequiresApi(Build.VERSION_CODES.O)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { LongitimeApp() }
	}
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun LongitimeApp(): Unit = LTimeTheme {
	Scaffold(
		topBar = { LTimeTopBar() },
		bottomBar = { LTimeBottomBar() }
	) { paddingValues ->
		ClockView(paddingValues)
	}
}
