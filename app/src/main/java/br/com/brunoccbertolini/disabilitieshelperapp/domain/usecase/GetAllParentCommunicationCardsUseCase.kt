package br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase

import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.domain.repository.CommunicationHelperRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllParentCommunicationCardsUseCase @Inject constructor(
    private val repository: CommunicationHelperRepository
) {
    suspend operator fun invoke(): Flow<List<Card>> =
        repository.getAllParentCard()
}