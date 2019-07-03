package com.rb.rb_test.di.ui.main

import com.rb.rb_test.di.scopes.FragmentScope
import com.rb.rb_test.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector(modules = [])
    abstract fun bindTransactionsListFragment(): MainFragment

}