package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainModel:ViewModel() {
        var itemList = mutableListOf<Item>(
                Item("january 4,2021","Tusuk Gigi","500","10")
        )


//        val itemLiveData: MutableLiveData<Re<Item>> = MutableLiveData<ResourceState>(itemList)
        var _isvalid = MutableLiveData<ResourceState>()
        val isValid : LiveData<ResourceState>
        get() {
                return _isvalid
        }
        fun addItem(date: String,name:String,price:String,quantity:String) {
                itemList.add(
                        Item(date,name,price,quantity)
                )
//                musicLiveData.value = itemList
        }

        fun inputValidation(date: String,name: String,price: String,quantity: String) {
                GlobalScope.launch {
                        _isvalid.postValue(ResourceState.loading())
                        delay(3000)
                        if(!name.isNullOrBlank()||!price.isNullOrBlank()||!date.isNullOrBlank()||!quantity.isNullOrBlank()) {
                                addItem(date, name, price, quantity)
                                _isvalid.postValue(ResourceState.success(true,"Succes add $name"))

                        } else {
                                _isvalid.postValue(ResourceState.fail("Form must not be empty"))
                        }
                }
        }

}
