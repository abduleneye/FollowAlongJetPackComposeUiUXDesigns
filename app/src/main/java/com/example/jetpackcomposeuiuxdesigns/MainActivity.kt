package com.example.jetpackcomposeuiuxdesigns

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation.BottomNavigationBar
import com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation.CardSection
import com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation.CurrenciesSection
import com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation.FinanceSection
import com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation.WalletSection
import com.example.jetpackcomposeuiuxdesigns.ui.theme.JetPackComposeUiUXDesignsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeUiUXDesignsTheme {
                // A surface container using the 'background' color from the theme

                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    HomeScreen()
                }
            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    @Composable
    private fun SetBarColor(color: Color){
        val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(
                    color = color
                )
            }
        }

    @Preview
    @Composable

    fun HomeScreen(){
        Scaffold(
            bottomBar = {
                BottomNavigationBar()
            }
        ) { padding ->
            Column(modifier = Modifier.fillMaxSize()
                .padding(padding)) {

                WalletSection()
                CardSection()
                Spacer(modifier = Modifier.height(16.dp))
                FinanceSection()
                CurrenciesSection()


            }


            //Spacer(modifier = Modifier.height(16.dp))



        }
    }




}
