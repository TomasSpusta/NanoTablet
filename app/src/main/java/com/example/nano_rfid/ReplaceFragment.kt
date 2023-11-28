package com.example.nano_rfid

import android.util.Log
import androidx.fragment.app.Fragment


// main fragment - middle
fun replaceFragment(
    fragment: Fragment, activity: MainActivity
) {
    val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.middle_fragment_container, fragment)
    fragmentTransaction.commit()
    //Log.i("${Global.nanoTag} res map", Global.reservationMap.toString())
}

// menu fragment - left
fun prepareMenu(
    fragment: Fragment, activity: MainActivity
) {
    val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.menu_fragment_container, fragment)
    fragmentTransaction.commit()

}

// reservation info fragment - right
fun reloadInfo(
    fragment: Fragment, activity: MainActivity
) {
    val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.res_info_fragment_container, fragment)
    fragmentTransaction.commit()

}

