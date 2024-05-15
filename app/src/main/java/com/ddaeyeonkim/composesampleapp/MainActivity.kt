package com.ddaeyeonkim.composesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.ddaeyeonkim.composesampleapp.ui.navigation.AppComposeNavigator
import com.ddaeyeonkim.composesampleapp.ui.navigation.LocalComposeNavigator
import com.ddaeyeonkim.composesampleapp.ui.navigation.SampleNavHost
import com.ddaeyeonkim.composesampleapp.ui.navigation.SampleNavigator
import com.ddaeyeonkim.composesampleapp.ui.theme.ComposeSampleAppTheme

class MainActivity : ComponentActivity() {

    private val navigator: AppComposeNavigator = SampleNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(
                LocalComposeNavigator provides navigator
            ) {
                ComposeSampleAppTheme {
                    val navHostController = rememberNavController()

                    LaunchedEffect(Unit) {
                        navigator.handleNavigationCommands(navHostController)
                    }

                    SampleNavHost(navHostController = navHostController)
                }
            }
        }
    }
}

