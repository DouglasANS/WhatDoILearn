package com.example.whatdoilearn.data

import androidx.lifecycle.LiveData
import com.example.whatdoilearn.data.database.LearnedItemDao
import com.example.whatdoilearn.entities.LearnedItem

class LearnedItemRepository(private val dao: LearnedItemDao) { /*pintor, so sei pintar parede*/
    val learnedItems: LiveData<List<LearnedItem>> = dao.getAll()

    fun  addNewItem(item: LearnedItem){
        dao.insert(item)
    }
}