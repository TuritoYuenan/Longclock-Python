package vn.turito.longitime.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import vn.turito.longitime.R

@Composable
fun LongitimeBottomBar() = BottomAppBar(
	actions = {
		IconButton(onClick = {/*TODO*/ }) {
			Icon(
				Icons.Rounded.Favorite,
				stringResource(R.string.label_settings)
			)
		}
	},
	floatingActionButton = {
		FloatingActionButton(onClick = { /*TODO*/ }) {
			Icon(Icons.Rounded.Add, "")
		}
	})
