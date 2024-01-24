package com.example.cleanarqformat.data.model

data class Installments(
    val amount: Double,
    val currency_id: String,
    val quantity: Int,
    val rate: Int
)