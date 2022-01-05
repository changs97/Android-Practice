package com.changs.layoutsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.changs.layoutsample.databinding.FragmentTextBinding


class TextFragment : Fragment() {

    private var _binding : FragmentTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeTextProperties (fontsize : Int, text : String){
        binding.textView4.textSize = fontsize.toFloat()
        binding.textView4.text = text
    }


}