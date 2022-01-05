package com.changs.layoutsample

import android.accessibilityservice.GestureDescription
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.changs.layoutsample.databinding.ActivityCommonGesturesBinding

//코드 반복을 줄여주는 BaseActivity를 상속, 제스처 처리를 위한 인터페이스 상속 (더블 탭의 감지가 필요하므로 따로 상속해줘야함.)
class CommonGesturesActivity : BaseActivity<ActivityCommonGesturesBinding>(ActivityCommonGesturesBinding::inflate),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    var gDetector : GestureDetectorCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gDetector = GestureDetectorCompat(this,this)
        gDetector?.setOnDoubleTapListener(this)



    }

    //true를 반환하는 것은 해당 이벤트가 해당 함수에서 소비되었으므로 스택에 있는 그 다음
    //이벤트 핸들러에 전달할 필요가 없다는 것을 안드로이드 프레임 워크에 나타내는 것이다.
    override fun onDown(p0: MotionEvent?): Boolean {
        binding.gestureStatusText.text = "onDown"
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {
        binding.gestureStatusText.text = "onShowPress"
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        binding.gestureStatusText.text = "onSingleTapUp"
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        binding.gestureStatusText.text = "onScroll"
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        binding.gestureStatusText.text = "onLongPress"
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        binding.gestureStatusText.text = "onFling"
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        binding.gestureStatusText.text = "onSingleTapConfirmed"
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        binding.gestureStatusText.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        binding.gestureStatusText.text = "onDoubleTapEvent"
        return true
    }

    //터치 이벤트를 감지하여 GestureDetectorCompat 인스턴스에 전달하는 코드를 추가
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gDetector?.onTouchEvent(event)
        // 슈퍼 클래스의 오버라이딩되는 함수를 호출해야 한다.
        return super.onTouchEvent(event)
    }
}