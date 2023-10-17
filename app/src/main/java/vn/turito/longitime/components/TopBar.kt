package vn.turito.longitime.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import vn.turito.longitime.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LTimeTopBar() = CenterAlignedTopAppBar(
	title = { Text(stringResource(R.string.app_name)) },
	actions = {
		IconButton(onClick = { /*TODO*/ }) {
			Icon(
				Icons.Rounded.Settings,
				stringResource(R.string.label_settings)
			)
		}
	},
	navigationIcon = {
		IconButton(onClick = { /*TODO*/ }) {
			Icon(
				Icons.Rounded.Info,
				stringResource(R.string.label_info)
			)
		}
	}
)
