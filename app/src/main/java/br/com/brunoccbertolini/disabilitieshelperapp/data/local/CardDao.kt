package br.com.brunoccbertolini.disabilitieshelperapp.data.local

import androidx.room.*
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Card)

    @Delete
    suspend fun deleteCard(card: Card)

    @Query("SELECT * FROM card WHERE parentCard")
    fun getAllParentCards(): Flow<List<Card>>

    @Query("SELECT * FROM card WHERE category= :category AND NOT parentCard")
    fun getAllCardsByCategory(category: String): Flow<List<Card>>


}