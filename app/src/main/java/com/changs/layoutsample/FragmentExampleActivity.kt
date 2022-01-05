package com.changs.layoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.changs.layoutsample.databinding.ActivityFragmentExampleBinding

class FragmentExampleActivity : FragmentActivity(), ToolbarFragment.ToolbarListener {
    private val binding by lazy {ActivityFragmentExampleBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val firstFragment = ToolbarFragment()
        firstFragment.arguments = intent.extras
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.containerView, firstFragment)
        transaction.commit()
    }

    override fun onButtonClick(fontsize: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(R.id.frameLayout2) as TextFragment
        textFragment.changeTextProperties(fontsize, text)
    }
}