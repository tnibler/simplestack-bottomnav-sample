package com.example.simplestack_bottomnav

import androidx.lifecycle.MutableLiveData
import com.zhuinden.simplestack.ScopedServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FlickerViewmodel(private val data: String) : ScopedServices.Registered {
    private val job = Job()
    val text = MutableLiveData("")

    override fun onServiceRegistered() {
        CoroutineScope(job).launch {
            delay(50)
            text.postValue(data.toUpperCase())
        }
    }

    override fun onServiceUnregistered() {
        job.cancel()
    }
}