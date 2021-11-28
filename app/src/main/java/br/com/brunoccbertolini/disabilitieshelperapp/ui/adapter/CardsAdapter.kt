package br.com.brunoccbertolini.disabilitieshelperapp.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.brunoccbertolini.disabilitieshelperapp.databinding.CardListItemBinding
import br.com.brunoccbertolini.disabilitieshelperapp.domain.model.Card
import com.bumptech.glide.Glide

class CardsAdapter: RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = differ.currentList[position]
        holder.bindView(card)
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((Card) -> Unit)? = null

    inner class ViewHolder(view: CardListItemBinding) : RecyclerView.ViewHolder(view.root) {
        private val cardImage: ImageView = view.ivCardImage
        private val cardTittle: TextView = view.tvCardTitle
        private val cardItem: CardView = view.cvItem

        fun bindView(card: Card) {
            card.apply {
                cardTittle.text = title
                cardItem.background.setTint(color)
                Glide.with(itemView.context)
                    .load(imgUrl)
                    .into(cardImage)
                itemView.setOnClickListener {
                    onItemClickListener?.let { it(card) }
                }

            }
        }
    }

    fun setOnItemClickListener(listener: (Card) -> Unit) {
        onItemClickListener = listener
    }
}
