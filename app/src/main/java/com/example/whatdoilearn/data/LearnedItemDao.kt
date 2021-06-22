package com.example.whatdoilearn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LearnedItemDao {
    @Query("SELECT * FROM learned_item ORDER BY item_level ASC")
    fun getAll(): List<LearnedItem>

    @Insert
    fun insert(LearnItem: LearnedItem)

}