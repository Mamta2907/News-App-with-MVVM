package com.mamta.mvvmnewsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.mamta.mvvmnewsapp.R
import com.mamta.mvvmnewsapp.adapter.ViewPagerAdapter
import com.mamta.mvvmnewsapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)

        adapter = ViewPagerAdapter(requireActivity())
        adapter.addFragment(TopNewsFragment(), "Top News")
        adapter.addFragment(SportNewsFragment(), "Sport")
        adapter.addFragment(TechnologyFragment(),"Technology")
        adapter.addFragment(BussinessFragment(),"Business")
        adapter.addFragment(EntertainmentFragment(),"Entertainment")
        adapter.addFragment(HealthFragment(),"Health")
        adapter.addFragment(ScienceFragment(),"Science")

        binding.pager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        return binding.root
    }


}