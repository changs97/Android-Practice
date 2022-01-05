package com.changs.layoutsample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.changs.layoutsample.databinding.FragmentToolbarBinding


class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    private var _binding : FragmentToolbarBinding? = null
    private val binding get() = _binding!!

    var seekvalue = 10



    var activityCallback : ToolbarListener? = null

    interface ToolbarListener {
        fun onButtonClick(fontsize : Int, text : String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.seekBar.setOnSeekBarChangeListener(this)
        binding.button2.setOnClickListener { v:View -> buttonClicked(v)}
    }

    private fun buttonClicked(v: View) {
        activityCallback?.onButtonClick(seekvalue, binding.editTextTextPersonName.text.toString())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString() + " must implement ToolbarListener")
        }
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        seekvalue = p1
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }



}