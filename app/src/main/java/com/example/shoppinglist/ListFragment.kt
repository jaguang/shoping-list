package com.example.shoppinglist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment() : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val stringBuilder = StringBuilder()
//        for ((index,item) in itemList.withIndex()) {
//            stringBuilder.append("${index + 1}. Tanggal : ${item.date}, Item : ${item.name}, Price : ${item.price}, Quantity : ${item.quantity} \n")
//
//        }
//        stringBuilder.append(" \n ")
//        view_item.text = stringBuilder

//    }


    companion object {
       @JvmStatic
        fun newInstance() = ListFragment()
    }
}