package com.example.whatdoilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdoilearn.R
import com.example.whatdoilearn.entities.LearnedItem
import com.example.whatdoilearn.entities.UnderstandingLevel

class LearnedItemAdapter: RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnItems = listOf<LearnedItem>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    /*LearnedItemViewHolder é a view referenciada. Ele é uma view Criada/Nova tipo TextView,Button*/
    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /*Pega as refecencias de um layout manipula os elementos*/
        private val titleContainer: TextView = itemView.findViewById(R.id.textTitle)
        private val desciptionContainer: TextView = itemView.findViewById(R.id.textDescription)
        private val level = itemView.findViewById(R.id.viewColor) as View

        fun bind(learnedItem: LearnedItem) { /*Trata Informações do banco de dados*/
            titleContainer.text = learnedItem.name
            desciptionContainer.text = learnedItem.description

            when (learnedItem.understandingLevel){
                UnderstandingLevel.LOW -> level.setBackgroundResource(R.color.red)
                UnderstandingLevel.MEDIUM -> level.setBackgroundResource(R.color.yellow)
                UnderstandingLevel.HIGH -> level.setBackgroundResource(R.color.green)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_learned_item, parent,false)
        /*O inflate que cria a view nova - se quiser fazer uma view a partir de um fragment/activity usa o inflater  */
        /*O onCreateViewHolder é quem escolhe qual tela/view vai ser o modelo de renderização*/

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        /*holder sabe qual layout vai trabalhar*/
        /*O holder pega a tela criada e com os dados inseridos faz a renderização com base na posição */
        val learnedItem = learnItems[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnItems.size /*Conta quantos itens serão renderizados*/
    }
}