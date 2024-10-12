package com.example.myapplication.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationDetailCategoryBinding

class NavigationDetailCategoryFragment : Fragment(){
    private var _binding: FragmentNavigationDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavigationDetailCategoryBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = arguments?.getString(NavigationCategoryFragment.EXTRA_NAME)
        val dataDesc = arguments?.getLong(NavigationCategoryFragment.EXTRA_STOCK)


        binding.tvNavigationCategoryName.text = "Name : $dataName"
        binding.tvNavigationCategoryDescription.text = "Stock : $dataDesc"

        binding.btnNavigationProfile.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigationDetailCategoryFragment_to_navigationHomeFragment)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}