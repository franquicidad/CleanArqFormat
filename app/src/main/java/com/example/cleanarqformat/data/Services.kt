package com.example.cleanarqformat.data

import com.example.cleanarqformat.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
// : https://api.mercadolibre.com/sites/MCO/search?q=telefono
    @GET("sites/MCO/search")
    suspend fun getProductsByQuery(@Query("q") q:String): SearchResponse

}