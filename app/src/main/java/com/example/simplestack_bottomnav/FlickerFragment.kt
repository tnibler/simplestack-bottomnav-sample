package com.example.simplestack_bottomnav

import android.os.Bundle
import android.view.View
import com.example.simplestack_bottomnav.databinding.FragmentFlickerBinding
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.lookup

class FlickerFragment : KeyedFragment(R.layout.fragment_flicker) {
//    private val viewModel: FlickerViewmodel by lazy { lookup() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFlickerBinding.bind(view)
        binding.textView.text = "Go back to see flicker."

/*
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textView.text = text
        }
*/
    }
}