package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    var shoe = Shoe("", 0.0, "", "")
        private set
    var shoeSize: String
        get() = shoe.size.toString()
        set(value) {
            shoe.size = value.toDoubleOrNull() ?: 0.0
        }
    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>> get() = _shoeList

    init {
        _shoeList.value = ArrayList()
    }

    fun addShoe() {
        _shoeList.value?.add(shoe)
        _shoeList.value = _shoeList.value
    }

    fun resetShoe() {
        shoe = Shoe("", 0.0, "", "")
    }

}
