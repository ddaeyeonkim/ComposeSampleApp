package com.ddaeyeonkim.composesampleapp.ui.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ddaeyeonkim.composesampleapp.ui.component.CommonTopAppBar

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CommonTopAppBar(title = "List")
        }
    ) { innerPadding ->
        // TODO
    }
}
