package vn.turito.longitime

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavbarItem(var name: String, var icon: ImageVector)

val navbarItems = listOf(
	NavbarItem("Clock", Icons.Rounded.Home),
	NavbarItem("Saved Clocks", Icons.Rounded.Favorite),
	NavbarItem("Location", Icons.Rounded.Place),
	NavbarItem("Settings", Icons.Rounded.Settings),
)
