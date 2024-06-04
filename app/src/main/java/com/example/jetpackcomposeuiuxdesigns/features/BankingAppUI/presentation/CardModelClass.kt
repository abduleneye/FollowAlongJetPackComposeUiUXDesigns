package com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation

import androidx.compose.ui.graphics.Brush

data class CardModelClass(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)
