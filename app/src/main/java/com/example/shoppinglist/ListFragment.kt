package com.example.shoppinglist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    lateinit var mainModel: MainModel
    lateinit var binding: FragmentListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
        subcribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)
        mainModel.getShopingList()
        return binding.root

    }

    fun subcribe() {
        mainModel.getShopingListLiveData.observe(this, Observer{
            binding.viewItem.text = it
        })
    }


    companion object {
       @JvmStatic
        fun newInstance() = ListFragment()
    }
}