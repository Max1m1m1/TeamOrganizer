package com.example.ozan.teamorganizer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ozan.teamorganizer.R
import com.example.ozan.teamorganizer.db.Player


class RecyclerViewPlayers(private val context: Context): RecyclerView.Adapter<RecyclerViewPlayers.RecyclerViewItemHolder>() {
    private var recyclerItemValues = emptyList<Player>()


    fun setData(items: List<Player>) {
        recyclerItemValues = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.recycler_view, parent, false)
        return RecyclerViewItemHolder(itemView)
    }


    override fun getItemCount(): Int {
        return recyclerItemValues.size
    }


    override fun onBindViewHolder(holder: RecyclerViewItemHolder, position: Int) {
        val item = recyclerItemValues[position]
        holder.bind(item)
    }




    inner class RecyclerViewItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val parentLayout: LinearLayout = itemView.findViewById(R.id.itemLayout)
        private val tvplayername: TextView = itemView.findViewById(R.id.tvItemName)
        private val tvplayerposition: TextView = itemView.findViewById(R.id.tvItemPosition)
        private val tvplayernumber: TextView = itemView.findViewById(R.id.tvItemNumber)
        private val tvplayerheight: TextView = itemView.findViewById(R.id.tvItemHeight)
        private val tvplayerweight: TextView = itemView.findViewById(R.id.tvItemWeight)


        fun bind(player: Player) {
            tvplayername.text = player.name
            tvplayerposition.text = player.position
            tvplayernumber.text = player.number.toString()
            tvplayerheight.text = player.height.toString()
            tvplayerweight.text = player.weight.toString()


        }


    }




}
