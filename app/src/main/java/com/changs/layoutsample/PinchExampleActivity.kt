package com.changs.layoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import com.changs.layoutsample.databinding.ActivityPinchExampleBinding

class PinchExampleActivity : BaseActivity<ActivityPinchExampleBinding>(ActivityPinchExampleBinding::inflate) {
    var scaleGestureDetector : ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ScaleGestureDetector 인스턴스 생성 이때 포함하는 액티비티의 참조와 내부 클래스의 인스턴스를 생성자의 인자로 전달
        scaleGestureDetector = ScaleGestureDetector(this, MyOnScaleGestureListener())
    }

    //이 함수에서는 ScaleGestureDetector 객체의 onTouchEvent() 함수를 호출한다. 이때 MotionEvent 객체를 인자로 전달한다.
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector?.onTouchEvent(event)
        return true
    }

    /*
    내부 클래스인 MyOnScaleGestureListener는 안드로이드의 SimpleOnScaleGestureListener 추상 클래스의 서브 클래스다. 따라서
    SimpleOnScaleGestureListener의 onScale(), onScaleBegin(), onScaleEnd() 함수를 구현해야 한다. 여기서는 onScale() 함수에서
    축척 계수를 확인한 후 감지된 핀치 제스처의 타입을 나타내는 메시지를 텍스트 뷰에 보여준다. 축척 계수가 1보다 크면 줌아웃이고, 아니면 줌인으로 간주
    */

    inner class MyOnScaleGestureListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val scaleFactor = detector.scaleFactor
            if(scaleFactor > 1) {
                binding.myTextView.text = "Zooming Out"
            }
            else{
                binding.myTextView.text = "Zooming In"
            }
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {

        }

    }
}