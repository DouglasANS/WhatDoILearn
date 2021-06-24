package com.example.whatdoilearn.DI

import com.example.whatdoilearn.data.LearnedItemRepository
import com.example.whatdoilearn.data.database.LearnItemDatabase
import com.example.whatdoilearn.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LearnedItemModel {
    val module = module {
        factory {
            CoroutineScope(Dispatchers.IO)
        }
        single {
            LearnItemDatabase.getDatabase(context = get(), scope = get())
        }
        single {
            get<LearnItemDatabase>().learnedItemDao()
        }
        factory {
            LearnedItemRepository(get())
        }
        viewModel {
            MainViewModel(get())
        }
    }
}