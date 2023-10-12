package vn.turito.longitime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.turito.longitime.ui.theme.LongitimeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { AppRoot() }
	}
}

@Preview(name = "Root")
@Composable
fun AppRoot() {
	LongitimeTheme {
		Scaffold(
			bottomBar = { Navbar() },
			modifier = Modifier.padding(1.dp)
		) { paddingValues ->
			Column(Modifier.padding(paddingValues)) {}
		}
	}
}

@Composable
fun Navbar() {
	var active by remember { mutableIntStateOf(0) }
	NavigationBar {
		navbarItems.forEachIndexed { index, item ->
			NavigationBarItem(
				icon = { Icon(item.icon, item.name) },
				label = { Text(item.name) },
				onClick = { active = index },
				selected = index == active,
			)
		}
	}
}
