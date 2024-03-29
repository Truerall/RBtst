package com.rb.rb_test.di

import android.app.Application
import com.rb.rb_test.utils.parsers.CSVParser
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RBAppProviderModule {

    @Provides
    @Singleton
    fun provideCSVParser(application: Application): CSVParser {
        return CSVParser(application)
    }
}