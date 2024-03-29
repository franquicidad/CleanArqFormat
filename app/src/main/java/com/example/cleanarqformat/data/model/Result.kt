package com.example.cleanarqformat.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    val accepts_mercadopago: Boolean,
    @SerializedName("attributes")val caracteris: List<Attribute>,
    val available_quantity: Int,
    val buying_mode: String,
    val catalog_listing: Boolean,
    val catalog_product_id: String,
    val category_id: String,
    val condition: String,
    val currency_id: String,
    val differential_pricing: DifferentialPricing,
    val discounts: Any,
    val domain_id: String,
    val id: String,
    val installments: Installments,
    val inventory_id: String,
    val listing_type_id: String,
    val official_store_id: Any,
    val order_backend: Int,
    val original_price: Any,
    val permalink: String,
    val price: Int,
    val promotions: List<Any>,
    val sale_price: Any,
    val seller: Seller,
    val shipping: Shipping,
    val site_id: String,
    val stop_time: String,
    val thumbnail: String,
    val thumbnail_id: String,
    val title: String,
    val use_thumbnail_id: Boolean,
    val winner_item_id: Any
)