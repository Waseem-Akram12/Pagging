package com.example.pagging.paggingsee

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagging.pagging.viewpagging2
import com.example.pagging.retrofit.Retrofitapi
import javax.inject.Inject

class paggingsee1 @Inject constructor(private var QuoteAPI: Retrofitapi) {
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { viewpagging2(QuoteAPI) }
    ).liveData
}