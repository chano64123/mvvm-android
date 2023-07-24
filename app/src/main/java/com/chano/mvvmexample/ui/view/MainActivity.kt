package com.chano.mvvmexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.chano.mvvmexample.databinding.ActivityMainBinding
import com.chano.mvvmexample.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViweModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViweModel.onCreate()

        quoteViweModel.quoteModel.observe(this, Observer {currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViweModel.isLoading.observe(this, Observer {loading ->
            binding.pbLoading.isVisible = loading
        })

        binding.viewContainer.setOnClickListener{ quoteViweModel.randomQuote()}
    }
}