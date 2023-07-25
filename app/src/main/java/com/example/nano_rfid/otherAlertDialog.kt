package com.example.nano_rfid

import android.app.AlertDialog
import android.view.LayoutInflater
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import com.example.nano_rfid.fragments.SharedViewModel


fun otherAlertDialog (activity: FragmentActivity, model: SharedViewModel) {

    val builder = AlertDialog.Builder(activity)
    val dialogLayout = LayoutInflater.from(activity).inflate(R.layout.other_layout, null)
    val editText = dialogLayout.findViewById<EditText>(R.id.et_others)


    builder.setView(dialogLayout)
    builder.setPositiveButton("OK") { dialogInterface, i ->
        val otherOption = editText.text.toString()

        //Log.d("al dialog","$otherOption in positive button")

        model.storeOther(otherOption)
        //val storedOtherOption = model.otherInfo.value.toString()


        //Log.d("al dialog","$storedOtherOption in positive button")
       // Toast.makeText(activity, "EditText is $otherOption", Toast.LENGTH_SHORT).show()
    }//&& Log.d("edittext","${editText.text} in positive button") }//Toast.makeText(context, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show() }

    builder.show()






}