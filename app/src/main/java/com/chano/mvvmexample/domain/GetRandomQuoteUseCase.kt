package com.chano.mvvmexample.domain

import com.chano.mvvmexample.data.QuoteRepository
import com.chano.mvvmexample.data.model.QuoteModel
import com.chano.mvvmexample.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}