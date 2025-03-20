package com.example.testmercadolibre.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.domain.usecase.GetHomeUseCase
import com.example.testmercadolibre.domain.usecase.GetSearchUseCase
import com.example.testmercadolibre.presentation.state.HomeState
import com.example.testmercadolibre.presentation.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getHomeUseCase: GetHomeUseCase) :
    ViewModel() {

    private val _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState> get() = _homeState

    fun getHome() {
        getHomeUseCase.invoke().onEach {
            when (it) {
                is ViewState.Loading -> {
                    _homeState.value = HomeState(isLoading = true)
                }

                is ViewState.Success -> {
                    _homeState.value = HomeState(data = it.data?.components)
                }

                is ViewState.Error -> {
                    _homeState.value = HomeState(error = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}