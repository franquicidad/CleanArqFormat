package com.example.cleanarqformat.ui.states

sealed class AppStates(){
     data object Loading:AppStates()
     data class Success(val data: Any): AppStates()
     data class Error(val error: String): AppStates()
}
