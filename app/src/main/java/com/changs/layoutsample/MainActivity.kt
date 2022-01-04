package com.changs.layoutsample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.changs.layoutsample.databinding.ActivityMainBinding


import android.view.LayoutInflater
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet


class MainActivity : AppCompatActivity() {
    //뷰 바인딩
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //부모 뷰
        val container = binding.container

        //인플레이터를 가져오는 방법 3가지
        val inflater1 = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflater2 = LayoutInflater.from(this)
        val inflater3: LayoutInflater = layoutInflater

        //인플레이트
        //inflate(xml파일, 만든 뷰를 넣을 부모 layout/container, 바로 inflate 할지의 여부)
        inflater1.inflate(R.layout.sub1, container, true)




    }
}