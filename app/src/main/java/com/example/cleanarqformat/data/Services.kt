package com.example.cleanarqformat.data

import retrofit2.http.GET

interface Services {
// : https://api.mercadolibre.com/sites/MCO/search?q=telefono
    @GET("/sites/MCO")
    suspend fun getProductsByQuery(@)

}