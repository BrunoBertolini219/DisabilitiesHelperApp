package br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase

import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.domain.repository.CommunicationHelperRepository
import javax.inject.Inject

class InsertCommunicationCardUseCase @Inject constructor(
    private val repository: CommunicationHelperRepository
) {

    suspend operator fun invoke(card: Card){
        repository.insertCard(card)
    }

}