package com.example.search.data.use_cases

import com.example.common.utils.NetworkResult
import com.example.search.data.repository.SearchRepoImpl
import com.example.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllRecipesUseCases constructor(@Inject val searchRepository: SearchRepository) {
operator fun invoke(q:String)= flow<NetworkResult> {  }

}