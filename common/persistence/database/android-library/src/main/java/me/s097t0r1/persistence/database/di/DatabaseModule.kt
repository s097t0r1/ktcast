package me.s097t0r1.persistence.database.di

import android.content.Context
import dagger.Module
import dagger.Provides
import me.s097t0r1.persistence.database.db.AppDatabase

@Module
internal abstract class DatabaseModule {

    companion object {

        @Provides
        fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)
    }
}