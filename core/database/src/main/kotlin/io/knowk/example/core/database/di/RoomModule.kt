package io.knowk.example.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.knowk.example.core.database.dao.FavoriteStoresDao
import io.knowk.example.core.database.room.KnowkDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideKnowkDatabase(
        @ApplicationContext context: Context,
    ): KnowkDatabase {
        return Room
            .databaseBuilder(context, KnowkDatabase::class.java, "knowk.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavoriteStoresDao(
        database: KnowkDatabase,
    ): FavoriteStoresDao {
        return database.favoriteStoresDao()
    }
}
