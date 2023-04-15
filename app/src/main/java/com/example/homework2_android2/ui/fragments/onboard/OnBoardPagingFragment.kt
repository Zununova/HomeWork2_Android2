package com.example.homework2_android2.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.homework2_android2.R
import com.example.homework2_android2.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        onClick()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                lottieAnimation.repeatCount = LottieDrawable.INFINITE
                lottieAnimation.repeatMode = LottieDrawable.REVERSE
                lottieAnimation.setAnimation(R.raw.first_animation)
                text.text = "Очень удобный функционал"
            }
            1 -> {
                lottieAnimation.repeatCount = LottieDrawable.INFINITE
                lottieAnimation.repeatMode = LottieDrawable.REVERSE
                lottieAnimation.setAnimation(R.raw.second_animation)
                text.text = "Быстрый, качественный продукт"
            }
            2 -> {
                lottieAnimation.repeatCount = LottieDrawable.INFINITE
                lottieAnimation.repeatMode = LottieDrawable.REVERSE
                lottieAnimation.setAnimation(R.raw.third_animationjson)
                text.text = "Куча функций и интересных фишек"
                fragmentOnBoardPagingText.text = "Начать работу"
            }
        }
    }

    private fun onClick() {
        binding.fragmentOnBoardPagingText.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment)
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onboarding_page_position"
    }
}