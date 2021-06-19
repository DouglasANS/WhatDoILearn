package com.example.whatdoilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdoilearn.R
import com.example.whatdoilearn.data.LearnedItem

class LearnedItemAdapter: RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnItems = listOf<LearnedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_learned_item, parent,false)

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        /*holder sabe qual layout vai trabalhar*/
        val learnedItem = learnItems[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnItems.size /*Conta quantos itens renderizados*/
    }

    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        /*Pega as refecencias de um layoute manipula os elementos*/
        private val titleContainer: TextView = itemView.findViewById(R.id.textTitle)
        private val desciptionContainer: TextView = itemView.findViewById(R.id.textDescription)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            desciptionContainer.text = learnedItem.description
        }

    }

}