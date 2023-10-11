package vn.turito.longitime

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.turito.longitime.ui.theme.LongitimeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { AppRoot() }
	}
}

val myIcons = Icons.Rounded

data class NavbarItem(var name: String, var icon: ImageVector)

val navbarItems = listOf(
	NavbarItem("Clock", myIcons.Home),
	NavbarItem("Saved Clocks", myIcons.Favorite),
	NavbarItem("Location", myIcons.Place),
	NavbarItem("Settings", myIcons.Settings),
)

@Preview(
	name = "App Root",
	uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
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
	NavigationBar {
		navbarItems.forEachIndexed { _, item ->
			NavigationBarItem(
				icon = { Icon(item.icon, item.name) },
				label = { Text(item.name) },
				selected = false,
				onClick = { /*TODO*/ }
			)
		}
	}
}
