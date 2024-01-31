package com.example.cleanarqformat.data

import com.example.cleanarqformat.domain.SearchRepository
import com.example.cleanarqformat.domain.model.ModelProduct
import javax.inject.Inject

class SearchRepositoryImplementation @Inject constructor(private val services: Services) :
    SearchRepository {
    override suspend fun getSearchRepository(query: String): List<ModelProduct> {
        var queryResult = listOf<ModelProduct>()

        runCatching { services.getProductsByQuery(query) }
            .onSuccess {

                queryResult = it.toDomain(it)

                return queryResult

            }
            .onFailure {
                val error = it.message

                val re = error
            }
        return queryResult
    }
}