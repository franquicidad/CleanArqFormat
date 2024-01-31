package com.example.cleanarqformat.data.model

import com.example.cleanarqformat.domain.model.ModelProduct

data class SearchResponse(
    val results: List<Result>
) {
    fun toDomain(searchResponse: SearchResponse): List<ModelProduct> {
        return searchResponse.results.map {
            ModelProduct(
                title = it.title,
                thumbnail = it.thumbnail,
                price = it.price.toString(),
                itemName = it.caracteris.map { it.value_name }.toString()
            )
        }

    }
}