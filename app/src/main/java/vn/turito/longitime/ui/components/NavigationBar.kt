package vn.turito.longitime.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector

data class NavbarItem(var name: String, var icon: ImageVector)

val navbarItems = listOf(
	NavbarItem("Clock", Icons.Rounded.Home),
	NavbarItem("Saved Clocks", Icons.Rounded.Favorite),
	NavbarItem("Location", Icons.Rounded.Place),
	NavbarItem("Settings", Icons.Rounded.Settings),
)

@Composable
fun NavBar() {
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
