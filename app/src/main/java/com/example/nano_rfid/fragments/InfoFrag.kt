package com.example.nano_rfid.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nano_rfid.databinding.InfoFragBinding

// information on main page after login
class InfoFrag : Fragment() {

    private var _binding: InfoFragBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = InfoFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding!!.tvInfoPage.text = "Please select one of instruments first."

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




