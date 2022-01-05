package com.changs.layoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.changs.layoutsample.databinding.ActivityEventExampleBinding

class EventExampleActivity : AppCompatActivity() {
    private val binding by lazy {ActivityEventExampleBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        binding.button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                binding.statusText.text = "Button clicked"
            }
        })
        */
        binding.button.setOnClickListener {
            binding.statusText.text = "Button clicked"
        }

        binding.button.setOnLongClickListener {
            binding.statusText.text = "Long button clicked"
            true
            /*
            setOnLongClickListener는 사용자가 클릭한 채로 계속 누르고 있는 경우에 발생한다. 이것을 이벤트 소비라 한다.
            길게 누르는 클릭은 표준 클릭을 감지하는 것과 다르게 Boolean 값을 반환해야 한다.
            만일 콜백 함수가 true 값을 반환하면 이벤트 처리가 끝난 것으로 간주되어 해당 이벤트는 폐기
            반면 false를 반환하면 안드로이드 프레임워크는 해당 이벤트가 여전히 처리되어야 한다고 여기고 해당 이벤트를 동일한 뷰에 등록한 그 다음의 일치하는
            이벤트 리스너에 전달한다.
             */
        }

    }
}