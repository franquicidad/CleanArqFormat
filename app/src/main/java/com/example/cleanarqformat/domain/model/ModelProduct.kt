package com.example.cleanarqformat.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelProduct(
    val title: String = "",
    val thumbnail: String = "",
    val price: String = "",
    val itemName: String = ""
):Parcelable
