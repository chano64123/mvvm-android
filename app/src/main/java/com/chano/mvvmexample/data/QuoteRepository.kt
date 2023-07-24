package com.chano.mvvmexample.data

import com.chano.mvvmexample.data.model.QuoteModel
import com.chano.mvvmexample.data.model.QuoteProvider
import com.chano.mvvmexample.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}