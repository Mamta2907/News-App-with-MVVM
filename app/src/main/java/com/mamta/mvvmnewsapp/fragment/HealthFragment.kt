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
import com.mamta.mvvmnewsapp.adapter.CategoryNewsAdapter
import com.mamta.mvvmnewsapp.databinding.FragmentHealthBinding
import com.mamta.mvvmnewsapp.viewmodel.HealthNewsViewModel


class HealthFragment : Fragment() {

    private var _binding: FragmentHealthBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryNewsAdapter: CategoryNewsAdapter
    private lateinit var healthNewsViewModel: HealthNewsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHealthBinding.inflate(inflater, container, false)



        binding.rvTopNews.layoutManager = LinearLayoutManager(requireContext())

        //Initialise the viewModel
        healthNewsViewModel =
            ViewModelProvider(requireActivity())[HealthNewsViewModel::class.java]

        healthNewsViewModel.getHealthNews()

        healthNewsViewModel.observeHealthNewsLiveData().observe(requireActivity(), Observer {
            categoryNewsAdapter = CategoryNewsAdapter(requireContext(), it)

            binding.rvTopNews.adapter = categoryNewsAdapter

        })

        // like this way we can send the data
        //topNewsViewModel.getTopNews("in", "49f2e42c782147fca18fab3c4c9f6693")

        healthNewsViewModel.observeErrorLiveData()
            .observe(viewLifecycleOwner, Observer { errorMessage ->
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            })



        return binding.root
    }


}