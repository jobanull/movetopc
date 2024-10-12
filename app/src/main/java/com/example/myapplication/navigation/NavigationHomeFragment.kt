package com.example.myapplication.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationHomeBinding

class NavigationHomeFragment : Fragment(){

    private var _binding: FragmentNavigationHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNavigationCategory.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigationHomeFragment_to_navigationCategoryFragment)
        )

        binding.btnNavigationProfile.setOnClickListener {
            view ->
            view.findNavController().navigate(R.id.action_navigationHomeFragment_to_navigationProfileActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}