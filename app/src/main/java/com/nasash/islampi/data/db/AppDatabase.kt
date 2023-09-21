package com.nasash.islampi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nasash.islampi.util.LogUtil
import com.getgoally.learnerapp.data.db.DateConverter
import com.getgoally.learnerapp.data.db.StringListConvert


@Database(
    entities = [com.nasash.islampi.data.model.api.token.Authentication::class],
    version = 1
)
@TypeConverters(DateConverter::class, StringListConvert::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAuthenticationDao(): com.nasash.islampi.data.db.dao.AuthenticationDao

    companion object {
        const val DATABASE_NAME = "SpeakerBus.db"

        var rdc: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                LogUtil.i("Database created!")
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                // do something every time database is open
            }
        }
    }
}