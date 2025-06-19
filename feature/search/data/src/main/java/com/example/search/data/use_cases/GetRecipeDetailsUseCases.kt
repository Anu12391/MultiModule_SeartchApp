package com.example.search.data.use_cases

import com.example.common.utils.NetworkResult
import com.example.search.domain.model.RecipesDetails
import com.example.search.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetRecipeDetailsUseCases constructor(@Inject val searchRepository: SearchRepository) {
    operator fun invoke(id: String) =
        flow<NetworkResult<RecipesDetails>> {
            emit(NetworkResult.Loading())
            val response = searchRepository.getRecipeDetails(id = id)
            if (response.isSuccess) {
                emit(NetworkResult.Success(data = response.getOrThrow()))
            } else {
                emit(NetworkResult.Error(message = response.exceptionOrNull()?.localizedMessage))
            }
        }.catch {
            emit(NetworkResult.Error(message = it.message))
        }.flowOn(Dispatchers.IO)


}