package com.example.retrofitfullgetpostpatchdelete

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.retrofitfullgetpostpatchdelete.model.User
import com.example.retrofitfullgetpostpatchdelete.network.RetrofitService

class UserPagingSource(private val apiService: RetrofitService): PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        TODO("Not yet implemented")
    }
    /*companion object{
        private const val FIRST_PAGE = 1
    }
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE
            val response = apiService.getUserList()

            LoadResult.Page(data = response.)
        }
    }*/
}