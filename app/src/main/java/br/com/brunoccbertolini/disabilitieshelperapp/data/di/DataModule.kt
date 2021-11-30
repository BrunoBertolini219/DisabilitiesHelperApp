package br.com.brunoccbertolini.disabilitieshelperapp.data.di

import android.content.Context
import androidx.room.Room
import br.com.brunoccbertolini.disabilitieshelperapp.data.local.CardDao
import br.com.brunoccbertolini.disabilitieshelperapp.data.local.CardDatabase
import br.com.brunoccbertolini.disabilitieshelperapp.data.repository.CommunicationHelperRepositoryImpl
import br.com.brunoccbertolini.disabilitieshelperapp.util.Constants.Companion.DATABASE_NAME
import br.com.brunoccbertolini.disabilitieshelperapp.domain.repository.CommunicationHelperRepository
import br.com.brunoccbertolini.disabilitieshelperapp.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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
    ): CommunicationHelperRepository = CommunicationHelperRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

}