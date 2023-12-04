package com.example.nano_rfid.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nano_rfid.R

// general adapter used when field type is pick one item
class GeneralAdapter(private val itemList: List<String>) : RecyclerView.Adapter<GeneralAdapter.MyViewHolder>() {
    private var selectedItemPosition: Int = -1
    var onItemClick: ((String) -> Unit)? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_rv_name)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_single_item_middle, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = itemList[position]

        holder.textView.text = item

        holder.textView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()

            onItemClick?.invoke(item)
            //https://www.youtube.com/watch?v=vDAO7H5w4_I&ab_channel=Indently

        }
        if (selectedItemPosition == position) {
            holder.textView.setBackgroundResource(R.drawable.submenu_button_selected)
        } else {
            holder.textView.setBackgroundResource(R.drawable.submenu_button)
        }
    }
}





