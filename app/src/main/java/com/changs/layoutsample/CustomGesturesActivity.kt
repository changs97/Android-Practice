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
        //GestureLibrary 인스턴스 생성, 제스처 파일 로드
        gLibrary = GestureLibraries.fromRawResource(this,R.raw.gestures)
        if (gLibrary?.load() == false) {
            finish()
        }

        binding.gOverlay.addOnGesturePerformedListener(this)
    }

    /*
    이 함수는 GestureOverlayView 객체에서 제스처가 수행될 때 자동 호출된다.
    이때 이 함수의 인자로는 제스처가 감지된 GestureOverlayView 객체의 참조와 Gesture 타입 객체가 함께 전달된다.
    Gesture 클래스는 특정 제스처를 정의하는 정보를 갖도록 설계되었다. 이 정보는 제스처를 구성하는 스트로크의 경로를 나타내는
    화면상의 연속된 점에 관한 것이다. Gesture 객체는 gLibrary 인스턴스의 recognize() 함수로 전달된다. 이 함수는 현재의 제스처를
    제스처 파일에서 로드된 각 제스처와 비교하는 목적을 갖는다. 비교 작업이 끝나면 recognize() 함수는 ArrayList 객체를 반환하는데,
    이 ArrayList에는 수행된 각 비교의 결과를 갖는 Prediction 객체가 저장된다. 이때 가장 잘 일치하는 것부터 차례대로 저장된다.
    각 Prediction 객체에는 제스처 파일에 있는 제스처 이름과 예측 점수가 포함된다. 이 점수는 제스처 파일의 제스처가
    현재의 제스처와 얼마나 가깝게 일치하는지를 나타낸다.

    따라서 이 함수의 코드에서는 인덱스 0(가장 가깝게 일치)에 있는 예측(점수가 1.0 이상이 확실한)을 취한다.
    그런 다음 일치하는 제스처의 이름을 알려 주는 Toast 메시지를 보여주겠다.
    */

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