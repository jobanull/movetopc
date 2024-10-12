package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class DetailCategoryFragment : Fragment() {

    private lateinit var tvCategoryName: TextView
    private lateinit var tvCategoryDescription: TextView
    private lateinit var btnProfile: Button
    private lateinit var btnShowDialog: Button
    var description: String? = null

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)

        btnProfile.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(intent)
        }

        btnShowDialog.setOnClickListener {
            val childFragment = childFragmentManager
            val optionDialogFragment = OptionDialogFragment()
            optionDialogFragment.show(childFragment, OptionDialogFragment::class.java.simpleName)
        }

        if(savedInstanceState != null){
            val descCategory = savedInstanceState.getString(EXTRA_DESC)
            description = descCategory
        }

        if(arguments != null){
            val devName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = devName
            tvCategoryDescription.text = description
        }
    }

    internal var optionDialogListener : OptionDialogFragment.OnOptionDialogListener = object :
        OptionDialogFragment.OnOptionDialogListener {
        override fun optionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()


        }
    }
}