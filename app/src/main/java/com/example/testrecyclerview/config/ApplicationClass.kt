package com.example.testrecyclerview.config

import android.app.Application
import android.content.SharedPreferences

// 앱 전역변수와 앱이 실행될 때 한번만 유지되면 되는 코드 생성(싱글톤 구현)
class ApplicationClass : Application() {

    // 코틀린의 전역변수 문법
    companion object{
        // 만들어져있는 SharedPreferences 를 사용해야합니다. 재생성하지 않도록 유념해주세요
        lateinit var sSharedPreferences: SharedPreferences
    }

}