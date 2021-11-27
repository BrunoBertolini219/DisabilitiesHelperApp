package br.com.brunoccbertolini.disabilitieshelperapp.data.di

import android.content.Context
import androidx.room.Room
import br.com.brunoccbertolini.disabilitieshelperapp.data.local.CardDao
import br.com.brunoccbertolini.disabilitieshelperapp.data.local.CardDatabase
import br.com.brunoccbertolini.disabilitieshelperapp.data.repository.CommunicationHelperRepositoyImpl
import br.com.brunoccbertolini.disabilitieshelperapp.util.Constants.Companion.DATABASE_NAME
import br.com.brunoccbertolini.disabilitieshelperapp.domain.repository.CommunicationHelperRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideCocktailDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, CardDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideCocktailDao(
        database: CardDatabase
    ) = database.getCardDao()

    @Singleton
    @Provides
    fun provideDefaultCommunicationRepository(
        dao: CardDao
    ): CommunicationHelperRepository = CommunicationHelperRepositoyImpl(dao)

}