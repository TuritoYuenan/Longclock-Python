package vn.turito.longitime.components

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
import androidx.compose.ui.res.stringResource
import vn.turito.longitime.R

data class NavbarItem(val name: String, val icon: ImageVector)

@Composable
fun NavBar() {
	var active by remember { mutableIntStateOf(0) }

	val navbarItems = listOf(
		NavbarItem(
			stringResource(R.string.navbar_settings),
			Icons.Rounded.Home
		),
		NavbarItem(
			stringResource(R.string.navbar_settings),
			Icons.Rounded.Favorite
		),
		NavbarItem(
			stringResource(R.string.navbar_settings),
			Icons.Rounded.Place
		),
		NavbarItem(
			stringResource(R.string.navbar_settings),
			Icons.Rounded.Settings
		),
	)

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
