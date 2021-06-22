package com.example.whatdoilearn.data

import androidx.room.TypeConverter
import com.example.whatdoilearn.R

class Converters {
    @TypeConverter
    fun levelToInt(level: UnderstandingLevel): Int {
        return level.ordinal /*ordem do understandinglevel*/
    }

    @TypeConverter
    fun intToLevel(int: Int): UnderstandingLevel{
        return when(int){
            UnderstandingLevel.LOW.ordinal -> UnderstandingLevel.LOW
            UnderstandingLevel.MEDIUM.ordinal -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH

        }
    }
}