package com.example.cleanarqformat.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarqformat.domain.useCases.SearchUseCase
import com.example.cleanarqformat.ui.states.AppStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchProductViewModel @Inject constructor(private val useCase: SearchUseCase) : ViewModel() {

    private var _states= MutableStateFlow<AppStates>(AppStates.Loading)
    val states: StateFlow<AppStates> = _states

    fun getProductSearchByQuery(query: String){
        viewModelScope.launch(Dispatchers.IO){
            supervisorScope {
                _states.value =AppStates.Loading
                val queryResult = withContext(Dispatchers.IO){useCase.invoke(query)}
                if (queryResult != null){
                    _states.value = AppStates.Success(queryResult)
                }else{
                    _states.value = AppStates.Error("Ha ocurrido un error")
                }
            }
        }

    }
}