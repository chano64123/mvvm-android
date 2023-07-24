package com.chano.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chano.mvvmexample.data.model.QuoteModel
import com.chano.mvvmexample.data.model.QuoteProvider
import com.chano.mvvmexample.domain.GetQuotesUseCase
import com.chano.mvvmexample.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    val getQuotesUseCases = GetQuotesUseCase()
    val getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result:List<QuoteModel>? = getQuotesUseCases()

            if (!result.isNullOrEmpty()){
                isLoading.postValue(false)
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }
}