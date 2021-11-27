package br.com.brunoccbertolini.disabilitieshelperapp.ui.fragment.cardschildren

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.brunoccbertolini.disabilitieshelperapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildrenCardsFragment : Fragment() {

    companion object {
        fun newInstance() = ChildrenCardsFragment()
    }

    private lateinit var viewModel: ChildrenCardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.children_cards_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChildrenCardsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}