package com.example.cleanarqformat.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarqformat.domain.model.ModelProduct
import com.example.cleanarqformat.domain.useCases.SearchUseCase
import com.example.cleanarqformat.ui.states.AppStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchProductViewModel @Inject constructor(private val useCase: SearchUseCase) : ViewModel() {

    private var _states = MutableStateFlow<AppStates>(AppStates.Loading)
    val states: StateFlow<AppStates> = _states

    private var _queryModelList = MutableStateFlow<List<ModelProduct>>(listOf())
    val queryModelList:StateFlow<List<ModelProduct>> =_queryModelList

    var queryResult = listOf<ModelProduct>()

    fun getProductSearchByQuery(query: String): List<ModelProduct> {
        viewModelScope.launch(Dispatchers.IO) {
            _states.value = AppStates.Loading
            withContext(Dispatchers.IO) {
                queryResult = useCase.invoke(query)!!

                if (queryResult != null) {
                    _states.value = AppStates.Success(queryResult)
                }else{
                    _states.value = AppStates.Error("Ha ocurrido un error")
                }
            }
        }
        return queryResult
    }
}