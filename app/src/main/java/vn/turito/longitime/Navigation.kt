package vn.turito.longitime

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LTimeNavigation(startDestination: String) {
	val navController = rememberNavController()
	NavHost(navController, startDestination) {
		// composable()
	}
}
