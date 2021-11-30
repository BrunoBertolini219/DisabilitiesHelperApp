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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunoccbertolini.disabilitieshelperapp.R
import br.com.brunoccbertolini.disabilitieshelperapp.databinding.ChildrenCardsFragmentBinding
import br.com.brunoccbertolini.disabilitieshelperapp.databinding.ParentCardsFragmentBinding
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.ui.adapter.CardsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

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
        setupCollector()
    }

    private fun setupCollector() {
        viewModel.getAllParentCards()

        lifecycleScope.launchWhenCreated {
            viewModel.getAllCardParentFlow.collect { event ->
                when(event) {
                    is ParentCardsViewModel.CardsState.Success -> {
                        adapterCard.differ.submitList(event.cards)
                    }
                }
            }
        }
    }


    private fun setupRecyclerView() {
        adapterCard = CardsAdapter()
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


}