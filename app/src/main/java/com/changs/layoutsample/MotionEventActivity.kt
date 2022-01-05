package com.changs.layoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.changs.layoutsample.databinding.ActivityMotionEventBinding

class MotionEventActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMotionEventBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.activityMotion.setOnTouchListener { view, motionEvent ->
            handleTouch(motionEvent)
            true
        }
    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount //터치 이벤트가 발생한 뷰의 포인터 개수를 알아낸다.
        //각 포인터에 대해 작업을 수행하는 for 루프를 초기화하기 위해 pointerCount 변수가 사용된다.
        for (i in 0 until pointerCount){
            val x = m.getX(i) //터치의 X좌표
            val y = m.getY(i) //터치의 Y좌표
            val id = m.getPointerId(i) //이벤트 id
            val action = m.actionMasked //액션 타입
            val actionIndex = m.actionIndex // 액션 인덱스
            var actionString : String // String 객체 참조 변수
            //when문을 사용해서 액션 타입을 확인한 후 각 액션 타입을 나타내는 문자열 값을 actionString 변수에 저장
            when(action){
                MotionEvent.ACTION_DOWN -> actionString = "DOWN"
                MotionEvent.ACTION_UP -> actionString = "UP"
                MotionEvent.ACTION_POINTER_DOWN -> actionString = "PNTR DOWN"
                MotionEvent.ACTION_POINTER_UP -> actionString = "PNTR UP"
                MotionEvent.ACTION_MOVE -> actionString = "MOVE"
                else -> actionString = ""
            }
            //actionString  값, 액션 인덱스, 터치 id와 XY좌표를 사용해서 문자열 메시지를 구성

            val touchStatus =
                "Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y"

            //구성된 문자열 메시지를 어떤 TextView 객체에 보여 줄 것인지를 결정하기 위해 id 값을 사용
            if (id == 0) binding.textView2.text = touchStatus else binding.textView3.text = touchStatus
        }
    }
}