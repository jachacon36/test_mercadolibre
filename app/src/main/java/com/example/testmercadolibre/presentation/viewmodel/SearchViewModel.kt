package com.example.testmercadolibre.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.domain.usecase.GetSearchUseCase
import com.example.testmercadolibre.presentation.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getSearchUseCase: GetSearchUseCase) : ViewModel() {

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> get() = _searchState

    fun getSearch(query: String) {
        getSearchUseCase.invoke(query = query).onEach {
            when (it) {
                is ViewState.Loading -> {
                    _searchState.value = _searchState.value.copy(isLoading = true)
                }

                is ViewState.Success -> {
                    _searchState.value = _searchState.value.copy(
                        isLoading = false,
                        data = it.data,
                        error = it.data?.results.isNullOrEmpty()
                    )
                }

                is ViewState.Error -> {
                    _searchState.value = _searchState.value.copy(
                        isLoading = false,
                        error = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun clearSearch() {
        _searchState.value = SearchState()
    }
}