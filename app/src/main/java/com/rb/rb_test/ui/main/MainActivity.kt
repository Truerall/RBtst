package com.rb.rb_test.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rb.rb_test.R
import com.rb.rb_test.ui.base.BaseInjectionActivity

class MainActivity : BaseInjectionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
