package com.example.cleanarqformat.data.model

data class Shipping(
    val benefits: Any,
    val free_shipping: Boolean,
    val logistic_type: String,
    val mode: String,
    val promise: Any,
    val store_pick_up: Boolean,
    val tags: List<String>
)