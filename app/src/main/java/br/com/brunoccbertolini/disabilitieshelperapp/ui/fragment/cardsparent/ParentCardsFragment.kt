package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardsparent

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.GeneratedAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunoccbertolini.disabilitieshelperapp.R
import br.com.brunoccbertolini.disabilitieshelperapp.databinding.ChildrenCardsFragmentBinding
import br.com.brunoccbertolini.disabilitieshelperapp.databinding.ParentCardsFragmentBinding
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.ui.adapter.CardsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentCardsFragment : Fragment() {


    private var _viewBinding: ParentCardsFragmentBinding? = null
    private val viewBinding: ParentCardsFragmentBinding get() = _viewBinding!!

    private val viewModel: ParentCardsViewModel by viewModels()

    private lateinit var adapterCard: CardsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = ParentCardsFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        onClickListener()
    }




    private fun setupRecyclerView() {
        adapterCard = CardsAdapter()
        adapterCard.differ.submitList(mockList())
        viewBinding.rvCardsParent.apply {
            adapter = adapterCard
            layoutManager = LinearLayoutManager(requireContext())

        }
    }

    private fun onClickListener(){
        adapterCard.setOnItemClickListener {
            Toast.makeText(requireContext(), "Clicked: ${it.title}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mockList():List<Card> {
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