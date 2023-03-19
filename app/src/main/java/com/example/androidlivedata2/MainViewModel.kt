package com.example.androidlivedata2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
    //값을 받아줄 getter
        get() = _mutableWord
    private var _randomMutableWord = MutableLiveData("")
    val randomliveWord : LiveData<String>
        //값을 받아줄 getter
        get() = _mutableWord

    val newData = Transformations.switchMap(liveWord){
        getRandomWordShuffled(it)
    }

    init {
        getNextData()
    }

    fun getNextData(){
        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)

    }

    fun getRandomWordShuffled(word: String): MutableLiveData<String>{
        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)
        return liveData
    }
}