package com.example.whatdoilearn.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.whatdoilearn.entities.LearnedItem
import com.example.whatdoilearn.entities.UnderstandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false) /*entidade = tabela nesse contexto*/
@TypeConverters(Converters::class) /* '::' Um jeito de acessar o nome da class / : deriva*/
abstract class LearnItemDatabase: RoomDatabase() {
    abstract fun learnedItemDao(): LearnedItemDao

    companion object{
        var INSTANCE: LearnItemDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LearnItemDatabase { /*Para evitar várias instancias de um BD*/
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LearnItemDatabase::class.java,
                    "learned_item_database"
                )
                    .addCallback(LearnItemDatabaseCallback(scope))
                    .build()
                    INSTANCE = instance
                    instance
            }
        }
    }
    /*herda comportamentos da roomdatabase.*/
    private class LearnItemDatabaseCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch {
                    populateDatabase(it.learnedItemDao())
                }
            }
        }

        private fun populateDatabase(learnedItemDao: LearnedItemDao) {
            val items = getAll()
                learnedItemDao.insert(items)
        }

        fun getAll(): List<LearnedItem> {
            return listOf(
                LearnedItem(name = "Kotlin", description = "Linguagem kotlin para Android", understandingLevel = UnderstandingLevel.HIGH),
                LearnedItem(name = "RecyclerView", description = "Listas em Android", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "DataClass", description = "Kotlin data Class", understandingLevel = UnderstandingLevel.LOW),
                LearnedItem(name = "Life Cycle", description = "Ciclo de vida de uma aplicação Android, Ciclo de vida de uma aplicação Android ", understandingLevel = UnderstandingLevel.HIGH),
                LearnedItem(name = "Intent", description = "Como usar intents", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "Services", description = "Service em  Android", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "Content Provider", description = "Dados com Contenct Provider", understandingLevel = UnderstandingLevel.LOW),
            )
        }
    }

}
