/*RecyclerviewAdapter.kt

package com.timetoprogram.recyclerviewexample
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_list_item.view.*
class RecyclerviewAdapter(private val listItems: ArrayList<String>): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {
    private var selectedItemPosition: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_list_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemLabel.text = listItems[position]
        holder.itemView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
        }
        if(selectedItemPosition == position)
            holder.cardView.setBackgroundColor(Color.parseColor("#DC746C"))
        else
            holder.cardView.setBackgroundColor(Color.parseColor("#E49B83"))
    }
    override fun getItemCount(): Int {
        return listItems.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemLabel: TextView = itemView.textView_listItem
        val cardView: LinearLayout = itemView.cardView
    }
}

 */