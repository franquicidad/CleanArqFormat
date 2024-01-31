package com.example.cleanarqformat.domain

import com.example.cleanarqformat.domain.model.ModelProduct

interface SearchRepository {
    suspend fun getSearchRepository(query:String) : List<ModelProduct>
}