package com.example.cleanarqformat.domain.useCases

import com.example.cleanarqformat.domain.SearchRepository
import com.example.cleanarqformat.domain.model.ModelProduct
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val searchRepository: SearchRepository) {
    suspend operator fun invoke(query:String) :List<ModelProduct>{
        return searchRepository.getSearchRepository(query)
    }
}