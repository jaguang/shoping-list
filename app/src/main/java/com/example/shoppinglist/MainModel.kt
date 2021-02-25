package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainModel:ViewModel() {
//        val itemLiveData: MutableLiveData<MutableList<Item>> = MutableLiveData(itemList)

        var getShopingListLiveData : MutableLiveData<String> = MutableLiveData()
        var itemList = mutableListOf<Item>(
                Item("january 4,2021","Tusuk Gigi","500","10")
        )

        var name = arrayListOf("Tahu Sumedang","Combro","Martabak")


        var _isvalid = MutableLiveData<ResourceState>()
        val isValid : LiveData<ResourceState>
                get() {
                        return _isvalid
                }
//        private var _nameList = MutableLiveData<ResourceState>()
//        val nameList : LiveData<ResourceState>
//                get() {
//                        return _nameList
//                }

//        fun onDateGetName(date: String) {
//                GlobalScope.launch {
//                _nameList.postValue(ResourceState.loading())
//                        delay(3000)
//                if( date == "1/1/2021") {
//                        _nameList.postValue(
//                                ResourceState.success(
//                                        arrayListOf(),"succes"
//
//                                )
//                        )
//                } else {
//                        _nameList.postValue(
//                                ResourceState.success(
//                                        arrayListOf("PHd","MCD","Tahu Goreng"),"success"
//                                )
//                        )
//                }
//                }
//        }




        fun addItem(date: String,name:String,price:String,quantity:String) {
                itemList.add(
                        Item(date,name,price,quantity)
                )
//                itemLiveData.value = itemList
        }


        fun getShopingList() {
                val stringBuilder = StringBuilder()
                for ((index, item) in itemList.withIndex()) {
                        stringBuilder.append("${index + 1}. Tanggal : ${item.date}, Item : ${item.name}, Price : ${item.price}, Quantity : ${item.quantity} \n")

                }
                getShopingListLiveData.value = stringBuilder.append(" \n ").toString()
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
