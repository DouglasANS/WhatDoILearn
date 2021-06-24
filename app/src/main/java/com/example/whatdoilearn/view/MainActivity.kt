package com.example.whatdoilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whatdoilearn.WhatDidILearnApplication
import com.example.whatdoilearn.databinding.ActivityMainBinding
import com.example.whatdoilearn.viewmodel.MainViewModel
import com.example.whatdoilearn.viewmodel.ViewModelFactory
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()
        recyclerView.adapter = adapter

        val items = viewModel.learnedItems

        items.observe(this, Observer {
            adapter.learnItems = it
        })
            /*Conector a tomada no adaptador juntou*/

        val adicionar = binding.floatingActionButton

        adicionar.setOnClickListener {
            val i = Intent(this, new_Learned_item::class.java)
            startActivity(i)

        }
    }
}