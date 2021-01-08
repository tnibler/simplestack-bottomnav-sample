package com.example.simplestack_bottomnav

import androidx.fragment.app.Fragment
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import kotlinx.parcelize.Parcelize

@Parcelize
class CKey : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = CFragment()
}