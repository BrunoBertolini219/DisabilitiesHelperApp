package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardsparent

import androidx.lifecycle.ViewModel
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.GetAllParentCommunicationCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ParentCardsViewModel @Inject constructor(
        private val getAllParentParentCards: GetAllParentCommunicationCardsUseCase
) : ViewModel() {

}