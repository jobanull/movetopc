package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R

class CategoryFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory : Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener {
            if(it.id == R.id.btn_detail_category){
                val detailCategoryFragment = DetailCategoryFragment()
                val fragmentManager = parentFragmentManager
                val bundle = Bundle()

                bundle.putString(DetailCategoryFragment.EXTRA_NAME, "LifeStyle")
                val desc = "Kategori Lifestyle"

                detailCategoryFragment.arguments = bundle
                detailCategoryFragment.description = desc

                fragmentManager
                    .beginTransaction()
                    .apply {
                        replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                            .addToBackStack(null)
                            .commit()
                    }
            }
        }
    }
}