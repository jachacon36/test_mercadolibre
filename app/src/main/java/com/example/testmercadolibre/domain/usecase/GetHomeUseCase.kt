package com.example.testmercadolibre.domain.usecase

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.domain.model.ComponetsJSONDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {

    operator fun invoke(): Flow<ViewState<ComponetsJSONDomainModel>> = flow {
        emit(ViewState.Loading())
        try {
            emit(ViewState.Success(data = repositoryImpl.getHome()))
        } catch (e: Exception) {
            emit(ViewState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}