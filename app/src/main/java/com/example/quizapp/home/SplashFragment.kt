package com.example.quizapp.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizapp.MainActivity
import com.example.quizapp.databinding.FrgmentSplashBinding

class SplashFragment:Fragment() {

    private lateinit var binding: FrgmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({

            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNewsFagment())

        }, 3000L)

    }
}