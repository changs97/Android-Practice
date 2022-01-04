package com.changs.layoutsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class ConstraintSetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureLayout()

    }

    private fun configureLayout() {
        //뷰 생성, 뷰 객체의 생성자 인자로 (Activity)Context 객체 참조를 전달해야 한다.
        val myButton = Button(this)
        myButton.text = getString(R.string.press_me) //getString으로 문자열 리소스를 참조할 수 있다.
        myButton.setBackgroundColor(Color.YELLOW) //배경 색을 설정할 수 있다.

        val myLayout = ConstraintLayout(this)
        myLayout.setBackgroundColor(Color.BLUE) //배경 색을 설정

        //addView로 자식 뷰 추가
        myLayout.addView(myButton)


        //뷰가 화면에 나타나게 한다.
        setContentView(myLayout)
    }
}