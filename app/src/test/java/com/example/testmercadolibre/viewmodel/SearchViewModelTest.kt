package com.example.testmercadolibre.viewmodel

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.domain.model.ResultDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel
import com.example.testmercadolibre.domain.usecase.GetSearchUseCase
import com.example.testmercadolibre.presentation.state.SearchState
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel
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
class SearchViewModelTest {

    @Mock
    private lateinit var getSearchUseCase: GetSearchUseCase

    private lateinit var searchViewModel: SearchViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockitoAnnotations.openMocks(this)
        searchViewModel = SearchViewModel(getSearchUseCase)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("Given a query, when getSearch is called, then searchState is updated to loading and then success with data")
    fun `getSearch updates searchState to loading and then success with data`() = runTest {
        val mock = mock(ResultDomainModel::class.java)
        val query = "test query"
        val searchResults = SearchDomainModel(results = listOf(mock, mock))

        `when`(getSearchUseCase.invoke(query)).thenReturn(flow {
            emit(ViewState.Loading(data = null))
            emit(ViewState.Success(data = searchResults))
        })

        searchViewModel.getSearch(query)

        advanceUntilIdle()
        assertEquals(false, searchViewModel.searchState.value.isLoading)
        assertEquals(searchResults, searchViewModel.searchState.value.data)
        assertEquals(false, searchViewModel.searchState.value.error)
    }

    @Test
    @DisplayName("Given a query, when getSearch is called, then searchState is updated to loading and then success with empty data")
    fun `getSearch updates searchState to loading and then success with empty data`() = runTest {
        val query = "test query"
        val searchResults = SearchDomainModel(results = emptyList())

        `when`(getSearchUseCase.invoke(query)).thenReturn(flow {
            emit(ViewState.Loading(data = null))
            emit(ViewState.Success(data = searchResults))
        })

        searchViewModel.getSearch(query)

        advanceUntilIdle()
        assertEquals(false, searchViewModel.searchState.value.isLoading)
        assertEquals(searchResults, searchViewModel.searchState.value.data)
        assertEquals(true, searchViewModel.searchState.value.error)
    }

    @Test
    @DisplayName("Given a query, when getSearch is called, then searchState is updated to loading and then error with message")
    fun `getSearch updates searchState to loading and then error with message`() = runTest {
        val query = "test query"
        val errorMessage = "Error"

        `when`(getSearchUseCase.invoke(query)).thenReturn(flow {
            emit(ViewState.Loading(data = null))
            emit(ViewState.Error(data = null, message = errorMessage))
        })

        searchViewModel.getSearch(query)

        advanceUntilIdle()
        assertEquals(false, searchViewModel.searchState.value.isLoading)
        assertEquals(null, searchViewModel.searchState.value.data)
        assertEquals(true, searchViewModel.searchState.value.error)
    }

    @Test
    @DisplayName("When clearSearch is called, then searchState and query are reset")
    fun `clearSearch resets searchState and query`() = runTest {
        searchViewModel.clearSearch()
        assertEquals(SearchState(), searchViewModel.searchState.value)
        assertEquals("", searchViewModel.query)
    }
}