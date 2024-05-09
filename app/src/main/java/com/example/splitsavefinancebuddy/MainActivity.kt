package com.example.splitsavefinancebuddy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.splitsavefinancebuddy.ui.theme.SplitSaveFinanceBuddyTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitsavefinancebuddy.HomescreenSections.CurrenciesSection
import com.example.splitsavefinancebuddy.HomescreenSections.DaysTotalSpendSection
import com.example.splitsavefinancebuddy.HomescreenSections.WalletSection
import com.example.splitsavefinancebuddy.navigation.appNavHost.AppNavHost
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_REGISTER
import com.example.splitsavefinancebuddy.navigation.routes.ROUTE_SPLIT
import com.example.splitsavefinancebuddy.ui.theme.screens.DashboardScreen
import com.example.splitsavefinancebuddy.ui.theme.splitscreen.SplitScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplitSaveFinanceBuddyTheme {
                DashboardScreen {amount, category ->
                    Log.d("SpendTracker", "Spent $amount on ${category.label}")
                }
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
    @Composable
    fun SetBarColor(color: androidx.compose.ui.graphics.Color){
        val systemUiController = rememberSystemUiController()
        SideEffect{
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Column(
    horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom)
    {

    }
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {

            WalletSection()
            DaysTotalSpendSection()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            {
                Image(painter = painterResource(id = R.drawable.login ),
                    contentDescription = "Background Image",
                    contentScale = ContentScale.FillBounds,
                    modifier=Modifier.matchParentSize())
                Text(text = "Welcome to SplitSave:FinanceBuddy",
                    color = Color.Black,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 30.sp)
                Spacer(modifier = Modifier.height(200.dp))
                Button(onClick = {
                    navController.navigate(ROUTE_SPLIT)
                }, modifier = Modifier.fillMaxWidth()) {
                   Box(modifier = Modifier
                       .padding(5.dp))
                   { Text(text = "Bill Splitter",
                       textDecoration = TextDecoration.Underline)}
                }
                Spacer(modifier = Modifier.height(200.dp))
                Button(onClick = {
                    navController.navigate(ROUTE_SPLIT)
                }, modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier
                        .padding(5.dp))
                    { Text(text = "Bill Splitter",
                        textDecoration = TextDecoration.Underline)}
                }
            }
        }
    }
}
@Preview
@Composable
fun HomescreenPreview(){
    HomeScreen(rememberNavController())
}








