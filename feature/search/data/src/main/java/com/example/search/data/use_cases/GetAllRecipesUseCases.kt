package com.example.search.data.use_cases

import com.example.common.utils.NetworkResult
import com.example.search.domain.model.Recipes

import com.example.search.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllRecipesUseCases constructor(@Inject val searchRepository: SearchRepository) {
    operator fun invoke(q: String) = flow<NetworkResult<List<Recipes>>> {
        emit(NetworkResult.Loading())
        val response = searchRepository.getRecipes(q)
        if (response.isSuccess) {
            emit(NetworkResult.Success(response.getOrThrow()))

        } else {
            emit(NetworkResult.Error(message = response.exceptionOrNull()?.localizedMessage))
        }
    }.catch {
        emit(NetworkResult.Error(message = it.localizedMessage ?: "Unexpected error occurred"))
    }.flowOn(Dispatchers.IO)

}