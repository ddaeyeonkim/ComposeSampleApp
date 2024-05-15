package com.ddaeyeonkim.composesampleapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ddaeyeonkim.composesampleapp.ui.navigation.Screens
import com.ddaeyeonkim.composesampleapp.ui.navigation.currentComposeNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val navigator = currentComposeNavigator

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("샘플앱") })
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                HomeButton(label = "Resources") {
                    navigator.navigate(Screens.Resources.name)
                }
            }
        }
    }
}

@Composable
fun HomeButton(label: String, onClick: () -> Unit) {
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = onClick,
    ) {
        Text(label)
    }
}