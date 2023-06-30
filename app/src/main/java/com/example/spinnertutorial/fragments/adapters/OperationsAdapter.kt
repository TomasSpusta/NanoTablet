package com.example.spinnertutorial.fragments.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.BLACK
import android.graphics.Color.RED
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.R
import com.example.spinnertutorial.lists.Instrument

class OperationsAdapter(private val operationsList: List<String>) : RecyclerView.Adapter<OperationsAdapter.MyViewHolder>() {


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
        return operationsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = operationsList[position]

        holder.textView.text = item

        holder.textView.setOnClickListener {
            onItemClick?.invoke(item)
        }



    }


}