package com.example.whatdoilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.whatdoilearn.WhatDidILearnApplication
import com.example.whatdoilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()
        recyclerView.adapter = adapter

        val repository = (application as WhatDidILearnApplication).repository
        val items = repository.learnedItems

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