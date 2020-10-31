package com.example.quizapp.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.quizapp.news.data.local.CoronaDao
import com.example.quizapp.news.data.modelfromservice.AllCountryItem
import com.example.quizapp.news.data.modelfromservice.AllInformation
import com.example.quizapp.util.Constants.DATA_BASE_NAME

@Database(
    entities = [AllCountryItem::class,AllInformation::class],

    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract class AppDataBase() : RoomDatabase() {
//
    abstract fun coronaDao(): CoronaDao
//
//    abstract fun tagDao(): TagDao
//
//    abstract fun userDao(): UserDao
//

//
//    companion object {
//
//        @Volatile
//        private var instance:AppDataBase?=null
//        private val LOCK=Any()
//
//        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
//            instance ?: buildDatabase(context).also { instance=it }
//        }
//
//
//        fun buildDatabase(
//            context: Context
//        ): AppDataBase {
//            return Room.databaseBuilder(context, AppDataBase::class.java, DATA_BASE_NAME)
//                .fallbackToDestructiveMigration()
//                .allowMainThreadQueries()
////                .addMigrations(migration12)
//                .build()
//        }
//    }

}