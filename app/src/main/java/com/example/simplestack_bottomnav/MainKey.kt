package com.example.simplestack_bottomnav

import androidx.fragment.app.Fragment
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import kotlinx.parcelize.Parcelize

@Parcelize
class MainKey : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = MainFragment()
}