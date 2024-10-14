package com.example.myapplication.ldp.repository.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class RepoSectionPagerAdapter internal constructor(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        val fragment = RepoNewsFragment()
        val bundle = Bundle()
        if (position == 0) {
            bundle.putString(RepoNewsFragment.ARG_TAB, RepoNewsFragment.TAB_NEWS)
        } else {
            bundle.putString(RepoNewsFragment.ARG_TAB, RepoNewsFragment.TAB_BOOKMARK)
        }
        fragment.arguments = bundle
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}