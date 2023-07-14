package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView

import androidx.fragment.app.Fragment
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
        var otherField = reservationMap["Fields"]!![("$selectedMenuItem value")]
        if (otherField?.isNotEmpty() == true) {
            binding.etOtherOption.setText(otherField, TextView.BufferType.EDITABLE)
        }

        // _binding!!.textView.text = "Please select one of instruments first"
        binding.btnSaveOther.setOnClickListener {
            otherField = binding.etOtherOption.text.toString()
            Log.i("Resp other field", otherField.toString())
            binding.etOtherOption.onEditorAction(EditorInfo.IME_ACTION_DONE)
            reservationMap["Fields"]!![("$selectedMenuItem value")] = otherField!!
            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




