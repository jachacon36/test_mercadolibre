package com.example.testmercadolibre.domain.usecase

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {

    operator fun invoke(id: String): Flow<ViewState<DetailProductDomainModel>> = flow {
        emit(ViewState.Loading())
        try {
            emit(ViewState.Success(data = repositoryImpl.getItem(id = id)))
        } catch (e: Exception) {
            emit(ViewState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}