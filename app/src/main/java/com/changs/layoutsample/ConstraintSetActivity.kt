package com.changs.layoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class ConstraintSetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun configureLayout() {
        //뷰 생성, 뷰 객체의 생성자 인자로 (Activity)Context 객체 참조를 전달해야 한다.
        val myButton = Button(this)
        val myLayout = ConstraintLayout(this)
        //addView로 자식 뷰 추가
        myLayout.addView(myButton)
        //뷰가 화면에 나타나게 한다.
        setContentView(myLayout)
    }
}