package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardschildren

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.DeleteCommunicationCardUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.GetAllCardsByCategoryUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.InsertCommunicationCardUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChildrenCardsViewModel @Inject constructor(
    private val insertCommunicationCardUseCase: InsertCommunicationCardUseCase,
    private val getAllCardsByCategoryUseCase: GetAllCardsByCategoryUseCase,
    private val deleteCommunicationCardUseCase: DeleteCommunicationCardUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private var _getAllCardsFlow = MutableStateFlow<CardsState>(CardsState.Empty)
    private val getAllCardsFlow: StateFlow<CardsState> = _getAllCardsFlow


    fun insertCard(card: Card) = viewModelScope.launch(dispatchers.io) {
        val response = insertCommunicationCardUseCase.invoke(card)
    }

    fun getAllParentCardsByCategory(card: Card) = viewModelScope.launch(dispatchers.io) {
        _getAllCardsFlow.value = CardsState.Loading
        val response = getAllCardsByCategoryUseCase.invoke(card.category)
        response.collect {
            _getAllCardsFlow.value = CardsState.Success(it)
        }
    }


    fun deleteCard(card: Card) = viewModelScope.launch(dispatchers.io) {
        deleteCommunicationCardUseCase.invoke(card)
    }


    sealed class CardsState {
        data class Success(val card: List<Card>) : CardsState()
        data class Error(val message: String) : CardsState()
        object Loading : CardsState()
        object Empty : CardsState()
    }

}