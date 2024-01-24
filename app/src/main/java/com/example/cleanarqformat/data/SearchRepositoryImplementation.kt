package com.example.cleanarqformat.data

import com.example.cleanarqformat.data.model.SearchResponse
import com.example.cleanarqformat.domain.SearchRepository
import javax.inject.Inject

class SearchRepositoryImplementation @Inject constructor(private val services: Services): SearchRepository {
    override suspend fun getSearchRepository(query: String): SearchResponse? {
         runCatching { services.getProductsByQuery(query) }
             .onSuccess { return it }
             .onFailure { return null }
        return null
    }
}