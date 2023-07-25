package com.example.nano_rfid.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.R

// now not used, but it is preparation for update dealing with various types of fields
// multiple choice etc. - not implemented yet, not completed yet
class SubMenuAdapter(private val itemList: List<String>) : RecyclerView.Adapter<SubMenuAdapter.MyViewHolder>() {
    private var selectedItemPosition: Int = -1
    var onItemClick: ((String) -> Unit)? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_rv_name)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_single_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = itemList[position]

        val menuItem = reservationMap["Fields"]!!["$position GUID"]

        holder.textView.text = item

        holder.textView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()

            onItemClick?.invoke(item)
            //https://www.youtube.com/watch?v=vDAO7H5w4_I&ab_channel=Indently

        }
        if (selectedItemPosition == position) {
            holder.textView.setBackgroundResource(R.drawable.menu_button_selected)
        } else {
            holder.textView.setBackgroundResource(R.drawable.menu_button)
        }
    }
}





