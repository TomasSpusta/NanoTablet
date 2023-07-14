package com.example.spinnertutorial.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.reservationMap

import com.example.spinnertutorial.R
import com.example.spinnertutorial.lists.MenuItem

class MenuAdapter(private val menuList: List<MenuItem>) : RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {
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
        return menuList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = menuList[position]
        holder.textView.text = item.name

        holder.textView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
            onItemClick?.invoke(position)
            //reservationMap[position.toString()] = mutableMapOf("name" to item.name,"guid" to item.GUID)
           reservationMap["Fields"]!!["$position name"] = item.name
            reservationMap["Fields"]!!["$position GUID"] = item.GUID

            //reservationMap["$position name"] = item.name
            //reservationMap["$position GUID"] = item.GUID


            Log.i("Resp res map", reservationMap.toString())

        }
        if (selectedItemPosition == position) {
            holder.textView.setBackgroundResource(R.drawable.menu_button_selected)
        } else {
            holder.textView.setBackgroundResource(R.drawable.menu_button)
        }

    }
}

