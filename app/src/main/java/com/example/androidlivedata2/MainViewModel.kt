package com.example.androidlivedata2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){

    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
    get() = _mutableCount

    //map을 활용하여 가공
    val mapLiveData = Transformations.map(liveCount){
        it+it
    }
    //switchMap을 활용하여 가공
    val switchMapLiveData = Transformations.switchMap(liveCount){
        changeValue(it)
    }
    fun changeValue(count : Int) : MutableLiveData<Int>{
        val testLiveData = MutableLiveData(count * count)

        return testLiveData
    }

    fun setLiveDataValue(count : Int){
        _mutableCount.value = count
    }



}