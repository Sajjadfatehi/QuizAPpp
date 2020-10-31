package com.example.quizapp.news.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentSingleCountryBinding

class SingleCountryFragment:Fragment() {
private lateinit var binding:FragmentSingleCountryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=  DataBindingUtil.inflate(inflater, R.layout.fragment_single_country,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args= arguments?.let { SingleCountryFragmentArgs.fromBundle(it) }

        binding.countryItem=args?.allCountryItem


    }
}