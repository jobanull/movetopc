package com.example.myapplication.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationCategoryBinding

class NavigationCategoryFragment : Fragment(){
    private var _binding : FragmentNavigationCategoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryLifestyle.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Lifestyle")
            mBundle.putLong(EXTRA_STOCK, 7)
            view.findNavController().navigate(R.id.action_navigationCategoryFragment_to_navigationDetailCategoryFragment, mBundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}