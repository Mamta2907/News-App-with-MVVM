package com.mamta.mvvmnewsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamta.mvvmnewsapp.R
import com.mamta.mvvmnewsapp.adapter.TopNewsAdapter
import com.mamta.mvvmnewsapp.databinding.FragmentTopNewsBinding
import com.mamta.mvvmnewsapp.viewmodel.TopNewsViewModel


class TopNewsFragment : Fragment() {

    private var _binding: FragmentTopNewsBinding? = null
    private val binding get() = _binding!!

    private lateinit var topNewsAdapter: TopNewsAdapter
    private lateinit var newsViewModel: TopNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentTopNewsBinding.inflate(inflater, container, false)

        binding.rvTopNews.layoutManager = LinearLayoutManager(requireContext())


        newsViewModel = ViewModelProvider(requireActivity())[TopNewsViewModel::class.java]
        newsViewModel.getTopNews()
        newsViewModel.observeTopNewsLiveData().observe(requireActivity(), Observer {
            topNewsAdapter = TopNewsAdapter(requireContext(),it)

            binding.rvTopNews.adapter = topNewsAdapter
        })




        return binding.root


    }


}