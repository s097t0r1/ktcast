package me.s097t0r1.persistence.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.s097t0r1.persistence.database.StubEntity

@Database(
    entities = [StubEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "WE_TALK_DATABASE"

        private lateinit var INSTANCE: AppDatabase

        fun getInstance(context: Context): AppDatabase {

            if (!this::INSTANCE.isInitialized) {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                        .build()
                }
            }

            return INSTANCE
        }
    }
}