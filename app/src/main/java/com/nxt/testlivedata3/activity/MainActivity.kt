package com.nxt.testlivedata3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nxt.testlivedata3.R
import com.nxt.testlivedata3.adapter.PagerAdapter
import com.nxt.testlivedata3.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment("Home", HomeFragment())
        adapter.addFragment("Health", HealthFragment())
        adapter.addFragment("Sport", SportFragment())
        adapter.addFragment("Science", ScienceFragment())
        adapter.addFragment("Technology", TechFragment())
        adapter.addFragment("Entertainment", EntertainmentFragment())

        vp_app.adapter = adapter
        tab_app.setupWithViewPager(vp_app)
    }
}