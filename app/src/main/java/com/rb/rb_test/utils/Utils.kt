package com.rb.rb_test.utils

import android.app.Application
import android.os.Build
import java.util.*

class Utils {

    companion object {

        @Suppress("DEPRECATION")
        fun getLocale(context: Application): Locale {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales.get(0);
            } else {
                context.resources.configuration.locale;
            }
        }
    }
}