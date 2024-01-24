package com.example.cleanarqformat.domain.useCases

import com.example.cleanarqformat.data.model.SearchResponse
import com.example.cleanarqformat.domain.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val searchRepository: SearchRepository) {
    suspend operator fun invoke(query:String) :SearchResponse?{
        return searchRepository.getSearchRepository(query)
    }
}