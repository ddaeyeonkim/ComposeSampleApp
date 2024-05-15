package com.ddaeyeonkim.composesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.ddaeyeonkim.composesampleapp.ui.navigation.SampleNavHost
import com.ddaeyeonkim.composesampleapp.ui.theme.ComposeSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            ComposeSampleAppTheme {
                SampleNavHost(navHostController = navHostController)
            }
        }
    }
}

