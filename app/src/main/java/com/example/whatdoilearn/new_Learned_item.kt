package com.example.whatdoilearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatdoilearn.databinding.ActivityMainBinding
import com.example.whatdoilearn.databinding.ActivityNewLearnedItemBinding

class new_Learned_item : AppCompatActivity() {

    lateinit var binding: ActivityNewLearnedItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewLearnedItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}