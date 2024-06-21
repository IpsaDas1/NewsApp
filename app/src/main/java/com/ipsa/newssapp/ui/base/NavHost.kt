package com.ipsa.newssapp.ui.base

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipsa.newssapp.ui.home.HomeScreen
import com.ipsa.newssapp.ui.topHeadline.TopHeadlineScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home Screen"){
        composable(route = "Home Screen"){
            HomeScreen(navController)
        }
        composable(route = "Top Headline"){
            TopHeadlineScreen(navController = navController)
        }
    }
}