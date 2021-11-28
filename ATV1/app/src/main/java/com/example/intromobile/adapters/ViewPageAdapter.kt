package com.example.intromobile.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.intromobile.fragments.fragment1
import com.example.intromobile.fragments.fragment2

class ViewPageAdapter(fragmentManager:FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                fragment1()
            }
            1->{
                fragment2()
            }
            else ->{
                Fragment()
            }
        }
    }
}