package com.example.testmercadolibre.usecase

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.domain.model.ComponentDomainModel
import com.example.testmercadolibre.domain.model.ComponetsJSONDomainModel
import com.example.testmercadolibre.domain.usecase.GetHomeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
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
class GetHomeUseCaseTest {

    @Mock
    private lateinit var repositoryImpl: RepositoryImpl

    private lateinit var getHomeUseCase: GetHomeUseCase

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockitoAnnotations.openMocks(this)
        getHomeUseCase = GetHomeUseCase(repositoryImpl)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("Given a valid response, when invoke is called, then emits loading and success with data")
    fun `invoke emits loading and success with data`() = runTest {
        val homeData = ComponetsJSONDomainModel(components = listOf(mock(ComponentDomainModel::class.java)))

        `when`(repositoryImpl.getHome()).thenReturn(homeData)

        val flow = getHomeUseCase.invoke()

        val emissions = flow.toList()
        assertEquals(ViewState.Loading::class, emissions[0]::class)
        assertEquals(ViewState.Success::class, emissions[1]::class)
        assertEquals(homeData, (emissions[1] as ViewState.Success).data)
    }

    @Test
    @DisplayName("Given an error response, when invoke is called, then emits loading and error with message")
    fun `invoke emits loading and error with message`() = runTest {
        val errorMessage = "Error"

        `when`(repositoryImpl.getHome()).thenThrow(RuntimeException(errorMessage))

        val flow = getHomeUseCase.invoke()

        val emissions = flow.toList()
        Assertions.assertTrue(emissions[0] is ViewState.Loading<*>)
        Assertions.assertTrue(emissions[1] is ViewState.Error<*> && (emissions[1] as ViewState.Error).message == errorMessage)
    }
}