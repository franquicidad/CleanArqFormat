package com.example.cleanarqformat.ui.states

sealed class AppStates(){
     data object Loading:AppStates()
     data class Success(val data: String): AppStates()
     data class Error(val error: String): AppStates()
}
