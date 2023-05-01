package com.example.middleexam

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class FragmentAdapter(fragmentActivity: FragmentActivity, fragments:ArrayList<BackFragment>):
    FragmentStateAdapter(fragmentActivity) {
    private var fragments: ArrayList<BackFragment>? = null
    init {
        this.fragments=fragments
    }
    override fun getItemCount(): Int {
        return fragments!!.size
    }
    override fun createFragment(position: Int): Fragment {
        return fragments!![position].back()
    }

}