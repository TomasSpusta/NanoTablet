package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView

import androidx.fragment.app.Fragment
import com.example.spinnertutorial.Global.menuFields
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.selectedMenuItem
import com.example.spinnertutorial.MainActivity
import com.example.spinnertutorial.databinding.OtherFragBinding
import com.example.spinnertutorial.reloadInfo

class OtherFrag : Fragment() {

// Showing edit text option when in menu selected Other

    private var _binding: OtherFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = OtherFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var inputField = reservationMap["Fields"]!![("$selectedMenuItem value")]
        if (inputField?.isNotEmpty() == true) {
            binding.etOtherOption.setText(inputField, TextView.BufferType.EDITABLE)
        }


        binding.btnSaveInput.setOnClickListener {
            inputField = binding.etOtherOption.text.toString()
            reservationMap["Fields"]!![("$selectedMenuItem value")] = inputField!!

            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)
            binding.etOtherOption.onEditorAction(EditorInfo.IME_ACTION_DONE)
            Log.i("Sub menu input", inputField.toString())
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




