package com.example.whatdoilearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatdoilearn.data.LearnItemDatabase
import com.example.whatdoilearn.databinding.ActivityMainBinding

import com.example.whatdoilearn.view.LearnedItemAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()

        adapter.learnItems = LearnItemDatabase.getAll()
        recycler.adapter = adapter

        /*Conector a tomada no adaptador juntou*/
    }
}