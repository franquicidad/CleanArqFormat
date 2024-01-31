package com.example.cleanarqformat.ui.states

import com.example.cleanarqformat.domain.model.ModelProduct

sealed class AppStates(){
     data object Loading:AppStates()
     data class Success(val data: List<ModelProduct>): AppStates()
     data class Error(val error: String): AppStates()
}
