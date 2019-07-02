package com.rb.rb_test.di

import com.rb.rb_test.di.main.MainActivityFragmentBuilder
import com.rb.rb_test.di.main.MainActivityModule
import com.rb.rb_test.di.scopes.ActivityScope
import com.rb.rb_test.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityFragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}