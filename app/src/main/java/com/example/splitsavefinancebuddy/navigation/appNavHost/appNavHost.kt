package com.example.splitsavefinancebuddy.navigation.appNavHost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splitsavefinancebuddy.HomeScreen
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_ACCOUNT
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_DASHBOARD
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_HOME
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_LOGIN
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_NOTIFICATIONS
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_REGISTER
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_SPLIT
import com.example.splitsavefinancebuddy.ui.theme.screens.DashboardScreen
import com.example.splitsavefinancebuddy.ui.theme.screens.login.LoginScreen
import com.example.splitsavefinancebuddy.ui.theme.screens.notifications.NotificationScreen
import com.example.splitsavefinancebuddy.ui.theme.screens.register.RegisterScreen
import com.example.splitsavefinancebuddy.ui.theme.splitscreen.SplitScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController =rememberNavController(),
               startDestination: String = ROUTE_REGISTER) {

    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination) {
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_SPLIT){
            SplitScreen(navController)
        }
        composable(ROUTE_NOTIFICATIONS){
            NotificationScreen(navController)
        }
        composable(ROUTE_ACCOUNT){

        }
    }
}