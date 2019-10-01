package com.burgan.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [NewsModel::class],version = 1)

abstract class AppDB : RoomDatabase() {


    abstract fun NewsDAO(): NewsDAO

    companion object {

        @Volatile

        private var INSTANCE: AppDB? = null

        fun getDatabase(context: Context): AppDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "cache"
                )
                    .allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}