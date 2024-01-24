package com.example.cleanarqformat.domain

import com.example.cleanarqformat.data.model.SearchResponse

interface SearchRepository {
    suspend fun getSearchRepository(query:String) : SearchResponse?
}