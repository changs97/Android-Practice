package com.changs.layoutsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintSetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureLayout()

    }

    private fun convertToPx(value : Int) : Int {
        val r = resources
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, value.toFloat(),
            r.displayMetrics).toInt()

        return px
    }

    private fun configureLayout() {
        //뷰 생성, 뷰 객체의 생성자 인자로 (Activity)Context 객체 참조를 전달해야 한다.
        val myButton = Button(this)
        myButton.text = getString(R.string.press_me) //getString으로 문자열 리소스를 참조할 수 있다.
        myButton.setBackgroundColor(Color.YELLOW) //배경 색을 설정할 수 있다.
        myButton.id = R.id.myButton //id를 지정

        val myEditText = EditText(this)
        myEditText.id = R.id.myEditText

        myEditText.width = convertToPx(200)

        val myLayout = ConstraintLayout(this)
        myLayout.setBackgroundColor(Color.BLUE)


        //addView로 자식 뷰 추가
        myLayout.addView(myButton)
        myLayout.addView(myEditText)


        //뷰가 화면에 나타나게 한다
        setContentView(myLayout)

        //제약을 설정하기 위한 ConstraintSet() 인스턴스 생성
        val set = ConstraintSet()

        //높이와 너비를 자신이 보여 주는 텍스트에 맞게 크기를 조정
        set.constrainHeight(myButton.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myButton.id, ConstraintSet.WRAP_CONTENT)

        //Button을 레이아웃의 정중앙에 오도록 제약 설정
        set.connect(myButton.id, ConstraintSet.START,
            ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
        set.connect(myButton.id, ConstraintSet.END,
            ConstraintSet.PARENT_ID, ConstraintSet.END, 0)
        set.connect(myButton.id, ConstraintSet.TOP,
            ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        set.connect(myButton.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)

        //EditText를 기존 Button의 70dp 위에 위치하며 수평으로 레이아웃의 중앙에 오도록 구성
        set.connect(myEditText.id, ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
        set.connect(myEditText.id, ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.connect(myEditText.id, ConstraintSet.BOTTOM,
            myButton.id, ConstraintSet.TOP, 70)

        //레이아웃에 제약 적용하기
        set.applyTo(myLayout)
    }
}