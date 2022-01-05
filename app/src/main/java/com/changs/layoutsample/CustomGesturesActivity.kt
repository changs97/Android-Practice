package com.changs.layoutsample

import android.gesture.Gesture
import android.gesture.GestureLibraries
import android.gesture.GestureLibrary
import android.gesture.GestureOverlayView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.changs.layoutsample.databinding.ActivityCustomGesturesBinding

class CustomGesturesActivity : BaseActivity<ActivityCustomGesturesBinding>(ActivityCustomGesturesBinding::inflate),
GestureOverlayView.OnGesturePerformedListener{
    var gLibrary : GestureLibrary? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureSetUp()
    }

    private fun gestureSetUp() {
        gLibrary = GestureLibraries.fromRawResource(this,R.raw.gestures)
        if (gLibrary?.load() == false) {
            finish()
        }

        binding.gOverlay.addOnGesturePerformedListener(this)
    }

    override fun onGesturePerformed(p0: GestureOverlayView?, p1: Gesture?) {
        val predictions = gLibrary?.recognize(p1)
        predictions?.let {
            if (it.size > 0 && it[0].score > 1.0) {
                val action = it[0].name
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show()
            }
        }
    }
}