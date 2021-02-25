//package com.example.shoppinglist
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import com.example.shoppinglist.databinding.DistrictItemBinding
//import com.example.shoppinglist.databinding.FragmentCreateBinding
//
//class DistrictAdapter(val nameState: ResourceState?) : BaseAdapter() {
//    private var name = arrayListOf("Daftar Nama Item")
//
//    init {
//        nameState?.data?.let {
//            name.clear()
//            name.addAll(it as List<String>)
//        }
//    }
//
//    override fun getCount() = name.size
//
//    override fun getItem(p0: Int): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemId(p0: Int): Long {
//        return 0
//    }
//
//    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val inflater = LayoutInflater.from(p2?.context)
//        val view: View
//        nameState?.apply {
//            when (nameState.status) {
//                ResourceStatus.LOADING -> {
//                    view = inflater.inflate(R.layout.loading_in_spinner, p2, false)
//                    return view
//                }
//                ResourceStatus.SUCCESS -> {
//                    view = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, p2, false)
//                    var creatBinding = FragmentCreateBinding.bind(view)
//                    creatBinding.apply {
//                        inputNameItem.setText(name[p0])
//                    }
//                    return view
//                }
//                ResourceStatus.FAIL -> {
//                    view = inflater.inflate(R.layout, p2, false)
//                    val itemBinding = DistrictItemBinding.bind(view)
//                    itemBinding.apply {
//                        districtTextView.setText("Gagal...")
//                    }
//                    return view
//                }
//            }
//        }
//        view = inflater.inflate(R.layout.district_item, p2, false)
//        val itemBinding = DistrictItemBinding.bind(view)
//        itemBinding.apply {
//            districtTextView.setText(name[p0])
//        }
//        return view
//
//    }
//}