package br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase

import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.domain.repository.CommunicationHelperRepository
import javax.inject.Inject

class DeleteCommunicationCardUseCase @Inject constructor(
    private val repository: CommunicationHelperRepository
) {
    suspend operator fun invoke(id: Card){
        repository.deleteCard(id)
    }
}