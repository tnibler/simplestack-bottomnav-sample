package com.example.simplestack_bottomnav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.simplestack_bottomnav.databinding.BottomnavMainBinding
import com.zhuinden.simplestackextensions.fragments.KeyedFragment

class MainFragment : KeyedFragment(R.layout.bottomnav_main) {
    private val TAG = javaClass.simpleName
    private lateinit var aFragment: AFragment
    private lateinit var bFragment: BFragment
    private lateinit var cFragment: CFragment
    private val fragments: Array<out Fragment>
        get() = arrayOf(aFragment, bFragment, cFragment)
    private var selectedIndex = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = BottomnavMainBinding.bind(view)

        val t  = childFragmentManager.beginTransaction()
        aFragment = (childFragmentManager.findFragmentByTag("A") as? AFragment)
                ?: AFragment().also { aFragment ->
                    Log.d(TAG, "creating A")
                    t.add(R.id.bottomNavFrameLayout, aFragment, "A")
                }
        bFragment = (childFragmentManager.findFragmentByTag("B") as? BFragment)
                ?: BFragment().also { bFragment ->
                    Log.d(TAG, "creating B")
                    t.add(R.id.bottomNavFrameLayout, bFragment, "B")
                }
        cFragment = (childFragmentManager.findFragmentByTag("C") as? CFragment)
                ?: CFragment().also { cFragment ->
                    Log.d(TAG, "creating C")
                    t.add(R.id.bottomNavFrameLayout, cFragment, "C")
                }
        t.commitNow()

        savedInstanceState?.let {
            selectedIndex = it.getInt("selectedIndex")
        }

        val selectedFragment = fragments[selectedIndex]
        selectFragment(selectedFragment)

        binding.bottomNav.setOnNavigationItemReselectedListener {  }
        binding.bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.nav_a -> selectFragment(aFragment)
                R.id.nav_b -> selectFragment(bFragment)
                R.id.nav_c -> selectFragment(cFragment)
                else -> throw IllegalArgumentException()
            }
            true
        }
    }

    private fun selectFragment(selectedFragment: Fragment) {
        var transaction = childFragmentManager.beginTransaction()
        Log.d(TAG, "selectFragment: $selectedFragment")
        fragments.forEachIndexed { index, fragment ->
            if(selectedFragment == fragment) {
//                transaction = transaction.attach(fragment)
                transaction = transaction.show(fragment)
                selectedIndex = index
                Log.d(TAG, "showing ${fragment}")
            } else {
                Log.d(TAG, "hiding ${fragment}")
                transaction = transaction.hide(fragment)
            }
        }
        transaction.commitNow()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selectedIndex", selectedIndex)
    }
}