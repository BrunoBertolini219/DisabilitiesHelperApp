package br.com.brunoccbertolini.disabilitieshelperapp.domain.repository

import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import kotlinx.coroutines.flow.Flow

interface CommunicationHelperRepository {

    suspend fun insertCard(card: Card)

    suspend fun getAllParentCard(): Flow<List<Card>>

    suspend fun deleteCard(card: Card)

    suspend fun getAllCardsByCategory(category: String): Flow<List<Card>>

}