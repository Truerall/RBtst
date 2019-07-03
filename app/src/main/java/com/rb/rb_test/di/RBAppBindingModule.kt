package com.rb.rb_test.di

import com.rb.rb_test.utils.rx.AppSchedulerProvider
import com.rb.rb_test.utils.rx.ISchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RBAppBindingModule {

    @Singleton
    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider
}