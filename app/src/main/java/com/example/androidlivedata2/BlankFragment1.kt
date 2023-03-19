package com.example.androidlivedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidlivedata2.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {

    private var _binding : FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: BlankViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        val view = binding.root


        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            viewModel.plusCountValue()

        }
        //왜 viewLifecycleOwner 사용하는가?
        viewModel.liveCount.observe(viewLifecycleOwner, Observer {
            binding.text1.text = it.toString()
        })
    }
}