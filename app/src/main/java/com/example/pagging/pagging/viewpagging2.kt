package com.example.pagging.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagging.model.User
import com.example.pagging.retrofit.Retrofitapi
import java.lang.Exception

class viewpagging2(private val pageApi : Retrofitapi) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val position = params.key ?: 1
            val response = pageApi.getQuotes(position)

            return LoadResult.Page(
                data = response.users,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.total) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

        }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }



}
