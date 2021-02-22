//package com.example.shoppinglist
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.NavController
//import kotlinx.android.synthetic.main.fragment_nav.*
//
//
//class NavFragment : Fragment(),View.OnClickListener {
//    private lateinit var navController: NavController
//   override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_nav, container, false)
//
//    }
//
//    companion object {
//       @JvmStatic
//        fun newInstance() = NavFragment()
//    }
//
//    override fun onClick(p0: View?) {
//        when(p0) {
//            button_list -> navController.navigate(R.id.action_navFragment_to_listFragment)
//            button_account -> navController.navigate(R.id.action_navFragment_to_accountFragment)
//            button_add -> navController.navigate(R.id.action_navFragment_to_createFragment)
//            button_history -> navController.navigate(R.id.action_navFragment_to_historyFragment)
//        }
//    }
//}