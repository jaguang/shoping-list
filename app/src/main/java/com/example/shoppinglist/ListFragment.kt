package com.example.shoppinglist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    lateinit var mainModel: MainModel
    lateinit var binding: FragmentListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)
        binding.apply {
            val stringBuilder = StringBuilder()
            for ((index, item) in mainModel.itemList.withIndex()) {
                stringBuilder.append("${index + 1}. Tanggal : ${item.date}, Item : ${item.name}, Price : ${item.price}, Quantity : ${item.quantity} \n")

            }
            stringBuilder.append(" \n ")
            viewItem.text = stringBuilder
        }
        return binding.root

    }


    companion object {
       @JvmStatic
        fun newInstance() = ListFragment()
    }
}