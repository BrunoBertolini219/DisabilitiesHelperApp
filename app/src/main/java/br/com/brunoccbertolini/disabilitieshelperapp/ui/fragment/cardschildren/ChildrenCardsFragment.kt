package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardschildren

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import br.com.brunoccbertolini.disabilitieshelperapp.R
import br.com.brunoccbertolini.disabilitieshelperapp.databinding.ChildrenCardsFragmentBinding
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import br.com.brunoccbertolini.disabilitieshelperapp.ui.adapter.CardsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildrenCardsFragment : Fragment() {

    private var _viewBinding: ChildrenCardsFragmentBinding? = null
    private val viewBinding: ChildrenCardsFragmentBinding = _viewBinding!!

    private lateinit var adapterCard: CardsAdapter

    private val viewModel: ChildrenCardsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = ChildrenCardsFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}