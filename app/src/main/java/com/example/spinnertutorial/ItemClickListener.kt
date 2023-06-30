package com.example.spinnertutorial

import android.content.ClipData.Item

interface ItemClickListener {
    fun onItemClickListener (item: Item, position : Int)
}