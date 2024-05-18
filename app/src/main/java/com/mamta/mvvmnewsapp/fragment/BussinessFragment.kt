package com.mamta.mvvmnewsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamta.mvvmnewsapp.R
import com.mamta.mvvmnewsapp.adapter.CategoryNewsAdapter
import com.mamta.mvvmnewsapp.databinding.FragmentBussinessBinding
import com.mamta.mvvmnewsapp.databinding.FragmentHealthBinding
import com.mamta.mvvmnewsapp.viewmodel.BusinessViewModel
import com.mamta.mvvmnewsapp.viewmodel.HealthNewsViewModel

class BussinessFragment : Fragment() {

    private var _binding: FragmentBussinessBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryNewsAdapter: CategoryNewsAdapter
    private lateinit var businessViewModel: BusinessViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBussinessBinding.inflate(inflater, container, false)

        binding.rvTopNews.layoutManager = LinearLayoutManager(requireContext())

        businessViewModel = ViewModelProvider(requireActivity())[BusinessViewModel::class.java]
        businessViewModel.getBusinessData()

        businessViewModel.observerBusinessLiveData().observe(requireActivity(), Observer {
            categoryNewsAdapter = CategoryNewsAdapter(requireContext(), it)

            binding.rvTopNews.adapter = categoryNewsAdapter
        })

        businessViewModel.errorLiveData().observe(requireActivity(), Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }


}