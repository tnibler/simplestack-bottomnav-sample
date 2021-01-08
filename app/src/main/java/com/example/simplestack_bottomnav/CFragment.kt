package com.example.simplestack_bottomnav

import android.os.Bundle
import android.view.View
import com.example.simplestack_bottomnav.databinding.FragmentCBinding
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack

class CFragment : KeyedFragment(R.layout.fragment_c) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCBinding.bind(view)
        binding.button.setOnClickListener {
            backstack.goTo(FlickerKey("asdf"))
        }
    }
}