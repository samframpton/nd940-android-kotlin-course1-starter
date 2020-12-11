package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>> get() = _shoeList

    init {
        _shoeList.value = ArrayList()
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _shoeList.value = _shoeList.value
    }

}
