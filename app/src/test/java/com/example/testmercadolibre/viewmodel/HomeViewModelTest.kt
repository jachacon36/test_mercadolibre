package com.example.testmercadolibre.viewmodel

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.domain.model.ComponentDomainModel
import com.example.testmercadolibre.domain.model.ComponetsJSONDomainModel
import com.example.testmercadolibre.domain.usecase.GetHomeUseCase
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExperimentalCoroutinesApi
@ExtendWith(MockitoExtension::class)
class HomeViewModelTest {

    @Mock
    private lateinit var getHomeUseCase: GetHomeUseCase

    private lateinit var homeViewModel: HomeViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockitoAnnotations.openMocks(this)
        homeViewModel = HomeViewModel(getHomeUseCase)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("Given a valid response, when getHome is called, then homeState is updated to loading and then success with data")
    fun `getHome updates homeState to loading and then success with data`() = runTest {
        val homeData = ComponetsJSONDomainModel(components = listOf(mock(ComponentDomainModel::class.java)))

        `when`(getHomeUseCase.invoke()).thenReturn(flow {
            emit(ViewState.Loading(data = null))
            emit(ViewState.Success(data = homeData))
        })

        homeViewModel.getHome()

        advanceUntilIdle()
        assertEquals(false, homeViewModel.homeState.value.isLoading)
        assertEquals(homeData.components, homeViewModel.homeState.value.data)
        assertEquals(false, homeViewModel.homeState.value.error)
    }

    @Test
    @DisplayName("Given an error response, when getHome is called, then homeState is updated to loading and then error with message")
    fun `getHome updates homeState to loading and then error with message`() = runTest {
        val errorMessage = "Error"

        `when`(getHomeUseCase.invoke()).thenReturn(flow {
            emit(ViewState.Loading(data = null))
            emit(ViewState.Error(data = null, message = errorMessage))
        })

        homeViewModel.getHome()

        advanceUntilIdle()
        assertEquals(false, homeViewModel.homeState.value.isLoading)
        assertEquals(null, homeViewModel.homeState.value.data)
        assertEquals(true, homeViewModel.homeState.value.error)
    }
}