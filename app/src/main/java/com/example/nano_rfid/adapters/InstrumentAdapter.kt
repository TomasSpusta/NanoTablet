package com.example.nano_rfid.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nano_rfid.R
import com.example.nano_rfid.lists.Instrument

// adapter responsible for instruments
class InstrumentAdapter(private val instrumentList: List<Instrument>) : RecyclerView.Adapter<InstrumentAdapter.MyViewHolder>() {
    private var selectedItemPosition: Int = -1
    var onItemClick: ((Instrument) -> Unit)? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_rv_name)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_single_item_middle, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return instrumentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = instrumentList[position]
        holder.textView.text = item.name

        holder.textView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
            onItemClick?.invoke(item)

        }
        if (selectedItemPosition == position) {
            holder.textView.setBackgroundResource(R.drawable.submenu_button_selected)
        } else {
            holder.textView.setBackgroundResource(R.drawable.submenu_button)
        }

    }
}