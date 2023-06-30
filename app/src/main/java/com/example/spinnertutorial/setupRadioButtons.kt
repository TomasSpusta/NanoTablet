package com.example.spinnertutorial

import android.app.Activity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.setPadding
import androidx.fragment.app.FragmentActivity
import com.example.spinnertutorial.lists.Lists

fun setupRadioButtons(
    listOfButtons: List<String>,
    activity: FragmentActivity,
    radioGroup: RadioGroup
) {
    val buttonsList: List<String> = listOfButtons
    val numberOfButtons = buttonsList.size

    for (i in 0 until numberOfButtons) {
        val radioButton = RadioButton(activity)

        radioButton.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton.textSize = 30.0F
        radioButton.setPadding(30)
        //radioButton.background =
        radioButton.text = buttonsList[i].toString()
        radioButton.id = i
        radioGroup.addView(radioButton)
    }
}
