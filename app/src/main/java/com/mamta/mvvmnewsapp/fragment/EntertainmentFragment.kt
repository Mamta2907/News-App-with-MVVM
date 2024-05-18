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
import com.mamta.mvvmnewsapp.databinding.FragmentEntertainmentBinding
import com.mamta.mvvmnewsapp.databinding.FragmentTechnologyBinding
import com.mamta.mvvmnewsapp.viewmodel.BusinessViewModel
import com.mamta.mvvmnewsapp.viewmodel.EntertainmentNewsViewModel


class EntertainmentFragment : Fragment() {

    private var _binding: FragmentEntertainmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryNewsAdapter: CategoryNewsAdapter
    private lateinit var entertainmentNewsViewModel: EntertainmentNewsViewModel


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
        _binding = FragmentEntertainmentBinding.inflate(inflater, container, false)

        binding.rvTopNews.layoutManager = LinearLayoutManager(requireContext())

        entertainmentNewsViewModel =
            ViewModelProvider(requireActivity())[EntertainmentNewsViewModel::class.java]
        entertainmentNewsViewModel.getBusinessData()

        entertainmentNewsViewModel.observerEntertainmentLiveData()
            .observe(requireActivity(), Observer {
                categoryNewsAdapter = CategoryNewsAdapter(requireContext(), it)

                binding.rvTopNews.adapter = categoryNewsAdapter
            })

        entertainmentNewsViewModel.errorLiveData().observe(requireActivity(), Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }


}