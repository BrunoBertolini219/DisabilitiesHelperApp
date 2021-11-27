package br.com.brunoccbertolini.disabilitieshelperapp.data.local

import android.content.Context
import androidx.room.*
import br.com.brunoccbertolini.disabilitieshelperapp.util.Constants.Companion.DATABASE_NAME

import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card

@Database ( entities = [Card::class], version = 1)
abstract class CardDatabase: RoomDatabase() {
    abstract fun getCardDao(): CardDao

    companion object {
        @Volatile
        private var instance: CardDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CardDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}