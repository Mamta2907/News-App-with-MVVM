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
import com.mamta.mvvmnewsapp.databinding.FragmentHealthBinding
import com.mamta.mvvmnewsapp.databinding.FragmentScienceBinding
import com.mamta.mvvmnewsapp.databinding.FragmentTopNewsBinding
import com.mamta.mvvmnewsapp.viewmodel.ScienceNewsViewModel


class ScienceFragment : Fragment() {

    private var _binding: FragmentScienceBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryNewsAdapter: CategoryNewsAdapter
    private lateinit var scienceNewsViewModel: ScienceNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScienceBinding.inflate(inflater, container, false)

        binding.rvTopNews.layoutManager = LinearLayoutManager(requireActivity())

        scienceNewsViewModel = ViewModelProvider(requireActivity())[ScienceNewsViewModel::class.java]
        scienceNewsViewModel.getScienceNews()

        scienceNewsViewModel.observeScienceLiveData().observe(requireActivity(), Observer {

            categoryNewsAdapter = CategoryNewsAdapter(requireContext(),it)
            binding.rvTopNews.adapter = categoryNewsAdapter
        })

        scienceNewsViewModel.observeErrorLiveData().observe(requireActivity(), Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }


}