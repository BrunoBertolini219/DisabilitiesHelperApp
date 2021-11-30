package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardsparent

import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunoccbertolini.disabilitieshelperapp.R
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.GetAllParentCommunicationCardsUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.domain.usecase.InsertCommunicationCardUseCase
import br.com.brunoccbertolini.disabilitieshelperapp.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParentCardsViewModel @Inject constructor(
    private val getAllParentCards: GetAllParentCommunicationCardsUseCase,
    private val insertCommunicationCardUseCase: InsertCommunicationCardUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private var _getAllCardParentFlow = MutableStateFlow<CardsState>(CardsState.Empty)
    val getAllCardParentFlow: StateFlow<CardsState> =
        _getAllCardParentFlow


    init {
        mockList().forEach {
            insertCard(it)
        }
    }

    fun insertCard(card: Card) = viewModelScope.launch(dispatchers.io) {
        val response = insertCommunicationCardUseCase.invoke(card)
    }

    fun getAllParentCards() = viewModelScope.launch(dispatchers.io) {
        _getAllCardParentFlow.value = CardsState.Loading
        val response = getAllParentCards.invoke()
        response.collect {
            _getAllCardParentFlow.value = CardsState.Success(it)
        }

    }

    sealed class CardsState {
        data class Success(val cards: List<Card>) : CardsState()
        data class Error(val message: String) : CardsState()
        object Loading : CardsState()
        object Empty : CardsState()
    }

    private fun mockList(): List<Card> {
        return listOf<Card>(
            Card(
                imgUrl = R.drawable.ic_sick,
                title = "DOR",
                color = Color.MAGENTA,
                category = "DOR",
                parentCard = true
            ),
            Card(
                imgUrl = R.drawable.ic_hot,
                title = "CALOR",
                color = Color.RED,
                category = "CALOR",
                parentCard = true
            ),
            Card(
                imgUrl = R.drawable.ic_cold,
                title = "FRIO",
                color = Color.BLUE,
                category = "FRIO",
                parentCard = true
            ),
            Card(
                imgUrl = R.drawable.ic_sleep,
                title = "DORMIR",
                color = Color.LTGRAY,
                category = "DORMIR",
                parentCard = true
            ),
            Card(
                imgUrl = R.drawable.ic_shower,
                title = "HIGIENE",
                color = Color.GREEN,
                category = "HIGIENE",
                parentCard = true
            ),
            Card(
                imgUrl = R.drawable.ic_food_time,
                title = "FOME/SEDE",
                color = Color.YELLOW,
                category = "FOME/SEDE",
                parentCard = true
            )
        )
    }

}