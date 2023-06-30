package com.example.spinnertutorial.fragments.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.R
import com.example.spinnertutorial.lists.ResParItem

class ResParAdapter(private val itemList: List<ResParItem>) : RecyclerView.Adapter<ResParAdapter.MyViewHolder>() {
    private var selectedItemPosition: Int = -1
    var onItemClick: ((Int) -> Unit)? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_rv_name)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_single_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        //Log.d("act", instrumentList.size.toString())
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = itemList[position]

        holder.textView.text = item.name

        holder.textView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()

            onItemClick?.invoke(selectedItemPosition)
            //https://www.youtube.com/watch?v=vDAO7H5w4_I&ab_channel=Indently

        }
        if (selectedItemPosition == position) {
            holder.textView.setBackgroundResource(R.drawable.menu_button_selected)
        } else {
            holder.textView.setBackgroundResource(R.drawable.menu_button)
        }


    }
}





