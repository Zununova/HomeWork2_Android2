package com.example.homework2_android2.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.homework2_android2.R
import com.example.homework2_android2.databinding.ActivityMainBinding
import com.example.homework2_android2.databinding.FragmentOnBoardBinding
import com.example.homework2_android2.ui.adapters.OnBoardAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.viewPager.adapter = OnBoardAdapter(this)
    }

    private fun setupListener() = with(binding.viewPager) {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.nextTxt.isInvisible = currentItem == 2
            }
        })

        binding.dotsIndicator.setViewPager2(binding.viewPager)
        binding.nextTxt.setOnClickListener() {
            if (currentItem < 2) {
                setCurrentItem(currentItem + 1, true)
            }
        }
    }
}




