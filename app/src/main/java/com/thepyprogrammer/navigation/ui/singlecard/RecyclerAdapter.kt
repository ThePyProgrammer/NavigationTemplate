package com.thepyprogrammer.navigation.ui.singlecard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.thepyprogrammer.navigation.R

class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val completeViewModel: CompleteViewModel
    private val titles = arrayOf("Title 0",
        "Title 1",
        "Title 2",
        "Title 3",
        "Title 4",
        "Title 5")
    private val details = arrayOf("Description 0",
        "Description 1",
        "Description 2",
        "Description 3",
        "Description 4",
        "Description 5")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetails.text = details[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView
        var itemDetails: TextView
        var context: Context

        init {
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetails = itemView.findViewById(R.id.item_detail)
            context = itemView.context
            itemView.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                val position = adapterPosition
                completeViewModel.adapterPosition.value = position
                navController.navigate(R.id.action_cardViewFragment_to_selectedFragment)
            }
        }
    }

    init {
        completeViewModel = ViewModelProvider((context as FragmentActivity)).get(CompleteViewModel::class.java)
    }
}