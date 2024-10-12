package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R


class HomeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory = view.findViewById<Button>(R.id.btn_category)
        btnCategory.setOnClickListener {
            if(it.id == R.id.btn_category){
                val fragmentManager = parentFragmentManager
                val categoryFragment = CategoryFragment()
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, categoryFragment, CategoryFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}