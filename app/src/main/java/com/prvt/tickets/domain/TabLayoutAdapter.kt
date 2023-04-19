package com.prvt.tickets.domain

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.prvt.tickets.ClosedTicketsFragment
import com.prvt.tickets.ProcessingTicketsFragment
import com.prvt.tickets.R
import com.prvt.tickets.ui.fragments.NewTicketsFragment


/**
 * @param activity -> Actividad en donde se encuentra el ViewPager2
 * @param itemList -> Lista de las tabs que tendrá el TabLayout
 *
 * Adaptador para el ViewPager2 encargado de presentar las vistas de las distintas tabs del TabLayout
 */

class TabLayoutAdapter(activity: AppCompatActivity, itemList: List<String>): FragmentStateAdapter(activity) {

    private val pagerList = itemList
    override fun getItemCount(): Int {
        return pagerList.size
    }


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewTicketsFragment()
            1 -> ProcessingTicketsFragment()
            2 -> ClosedTicketsFragment()
            else -> NewTicketsFragment()
        }
    }
}