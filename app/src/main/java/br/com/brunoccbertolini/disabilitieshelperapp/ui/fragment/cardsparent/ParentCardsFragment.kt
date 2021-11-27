package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardsparent

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.brunoccbertolini.disabilitieshelperapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentCardsFragment : Fragment() {

    companion object {
        fun newInstance() = ParentCardsFragment()
    }

    private lateinit var viewModel: ParentCardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.parent_cards_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ParentCardsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}