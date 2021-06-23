package com.example.whatdoilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.whatdoilearn.data.LearnedItemRepository
import com.example.whatdoilearn.entities.LearnedItem

class MainViewModel(private val repository: LearnedItemRepository): ViewModel() {
    val learnedItems: LiveData<List<LearnedItem>> = repository.learnedItems

}