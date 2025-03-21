package com.example.testmercadolibre.usecase

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.domain.model.ResultDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel
import com.example.testmercadolibre.domain.usecase.GetSearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExperimentalCoroutinesApi
@ExtendWith(MockitoExtension::class)
class GetSearchUseCaseTest {

    @Mock
    private lateinit var repositoryImpl: RepositoryImpl

    private lateinit var getSearchUseCase: GetSearchUseCase

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockitoAnnotations.openMocks(this)
        getSearchUseCase = GetSearchUseCase(repositoryImpl)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("Given a valid query, when invoke is called, then emits loading and success with data")
    fun `invoke emits loading and success with data`() = runTest {
        val query = "test query"
        val searchResults = SearchDomainModel(
            results = listOf(
                mock(ResultDomainModel::class.java),
                mock(ResultDomainModel::class.java)
            )
        )

        `when`(repositoryImpl.getSearch(query)).thenReturn(searchResults)

        val flow = getSearchUseCase.invoke(query)

        val emissions = flow.toList()
        assertEquals(ViewState.Loading::class, emissions[0]::class)
        assertEquals(ViewState.Success::class, emissions[1]::class)
        assertEquals(searchResults, (emissions[1] as ViewState.Success).data)
    }

    @Test
    @DisplayName("Given a valid query, when invoke is called, then emits loading and success with empty data")
    fun `invoke emits loading and success with empty data`() = runTest {
        val query = "test query"
        val searchResults = SearchDomainModel(results = emptyList())

        `when`(repositoryImpl.getSearch(query)).thenReturn(searchResults)

        val flow = getSearchUseCase.invoke(query)

        val emissions = flow.toList()
        assertEquals(ViewState.Loading::class, emissions[0]::class)
        assertEquals(ViewState.Success::class, emissions[1]::class)
    }

    @Test
    @DisplayName("Given a valid query, when invoke is called, then emits loading and error with message")
    fun `invoke emits loading and error with message`() = runTest {
        val query = "test query"
        val errorMessage = "Error"

        `when`(repositoryImpl.getSearch(query)).thenThrow(RuntimeException(errorMessage))

        val flow = getSearchUseCase.invoke(query)

        val emissions = flow.toList()
        assertTrue(emissions[0] is ViewState.Loading<*>)
        assertTrue(emissions[1] is ViewState.Error<*> && (emissions[1] as ViewState.Error).message == errorMessage)
    }
}