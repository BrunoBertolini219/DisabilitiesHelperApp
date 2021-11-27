package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardschildren

import androidx.lifecycle.ViewModel
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.DeleteCommunicationCardUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.GetAllCardsByCategoryUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.InsertCommunicationCardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChildrenCardsViewModel @Inject constructor(
    private val insertCommunicationCardUseCase: InsertCommunicationCardUseCase,
    private val getAllCardsByCategoryUseCase: GetAllCardsByCategoryUseCase,
    private val deleteCommunicationCardUseCase: DeleteCommunicationCardUseCase
) : ViewModel() {

}