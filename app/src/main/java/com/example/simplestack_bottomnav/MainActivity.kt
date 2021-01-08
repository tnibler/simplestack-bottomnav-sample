package com.example.simplestack_bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplestack_bottomnav.databinding.MainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentStateChanger
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider

class MainActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {
    private val TAG = javaClass.simpleName

    private lateinit var fragmentStateChanger: DefaultFragmentStateChanger
    private var bottomNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentStateChanger = DefaultFragmentStateChanger(supportFragmentManager, R.id.mainFrameLayout)

        Navigator.configure()
                .setStateChanger(SimpleStateChanger(this))
                .setGlobalServices((application as App).globalServices)
                .setScopedServices(DefaultServiceProvider())
                .install(this, binding.mainFrameLayout, History.of(MainKey()))
    }

    override fun onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed()
        }
    }

    override fun onNavigationEvent(stateChange: StateChange) {
        fragmentStateChanger.handleStateChange(stateChange)
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomNav = null
    }
}
