package com.example.simplestack_bottomnav

import androidx.fragment.app.Fragment
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import com.zhuinden.simplestackextensions.servicesktx.add
import kotlinx.parcelize.Parcelize

@Parcelize
class FlickerKey(val data: String) : DefaultFragmentKey(), DefaultServiceProvider.HasServices {
    override fun instantiateFragment(): Fragment = FlickerFragment()

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
//            add(FlickerViewmodel(data))
        }
    }

    override fun getScopeTag(): String = fragmentTag
}