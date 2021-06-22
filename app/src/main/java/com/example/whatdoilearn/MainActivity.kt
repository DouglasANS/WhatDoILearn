package com.example.whatdoilearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.whatdoilearn.data.LearnItemDatabase
import com.example.whatdoilearn.databinding.ActivityMainBinding
import com.example.whatdoilearn.view.LearnedItemAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adicionar = binding.floatingActionButton

        val recycler = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()

        adapter.learnItems = LearnItemDatabase.getAll()
        recycler.adapter = adapter

        adicionar.setOnClickListener {
            val i = Intent(this, new_Learned_item::class.java)
            startActivity(i)
        }

        /*Conector a tomada no adaptador juntou*/
    }
}