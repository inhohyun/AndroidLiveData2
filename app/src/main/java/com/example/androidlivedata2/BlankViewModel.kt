package com.example.androidlivedata2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel(){
    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    //liveData값을 1증가시키는 함수수
   fun plusCountValue(){
        _mutableCount.value = _mutableCount.value?.plus(1)
    }


}