package com.example.pagging.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagging.paggingsee.paggingsee1
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class viewmodelapi @Inject constructor(private val repository: paggingsee1) : ViewModel() {
    val list = repository.getQuotes().cachedIn(viewModelScope)
}