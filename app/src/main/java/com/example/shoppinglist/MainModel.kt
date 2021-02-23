package com.example.shoppinglist

import androidx.lifecycle.ViewModel

class MainModel:ViewModel() {
        var itemList = mutableListOf<Item>(
                Item("january 4,2021","Tusuk Gigi","500","10")
        )

        fun addItem(date: String,name:String,price:String,quantity:String) {
                itemList.add(
                        Item(date,name,price,quantity)
                )
        }

}
