package br.com.brunoccbertolini.disabilitieshelperapp.data.repository

import br.com.brunoccbertolini.disabilitieshelperapp.data.local.CardDao
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.domain.repository.CommunicationHelperRepository
import br.com.brunoccbertolini.disabilitieshelperapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommunicationHelperRepositoryImpl @Inject constructor(
    private val cardDao: CardDao
): CommunicationHelperRepository {
    override suspend fun insertCard(card: Card) =
        cardDao.insertCard(card)

    override suspend fun getAllParentCard(): Flow<List<Card>> =
       cardDao.getAllParentCards()

    override suspend fun deleteCard(card: Card) =
        cardDao.deleteCard(card)

    override suspend fun getAllCardsByCategory(category: String): Flow<List<Card>> =
         cardDao.getAllCardsByCategory(category)





}