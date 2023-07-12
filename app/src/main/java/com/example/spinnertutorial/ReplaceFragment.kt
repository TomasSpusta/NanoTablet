package com.example.spinnertutorial

import androidx.fragment.app.Fragment


fun replaceFragment(
    fragment: Fragment,

    activity: MainActivity

) {
    //val model = ViewModelProvider(owner)[SharedViewModel::class.java]
    val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.middle_fragment_container, fragment)
    fragmentTransaction.commit()
}

fun prepareMenu(
    fragment: Fragment,
    activity: MainActivity
) {
    val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.menu_fragment_container, fragment)
    fragmentTransaction.commit()
}

fun reloadInfo(
    fragment: Fragment,
    activity: MainActivity
) {
    val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.res_info_fragment_container, fragment)
    fragmentTransaction.commit()
}