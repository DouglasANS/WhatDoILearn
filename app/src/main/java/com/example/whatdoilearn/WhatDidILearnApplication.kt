package com.example.whatdoilearn

import android.app.Application
import com.example.whatdoilearn.DI.LearnedItemModel
import com.example.whatdoilearn.data.LearnedItemRepository
import com.example.whatdoilearn.data.database.LearnItemDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WhatDidILearnApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatDidILearnApplication)
            modules(LearnedItemModel.module)
        }
    }
}