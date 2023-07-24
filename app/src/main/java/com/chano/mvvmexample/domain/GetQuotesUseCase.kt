package com.chano.mvvmexample.domain

import com.chano.mvvmexample.data.QuoteRepository
import com.chano.mvvmexample.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}