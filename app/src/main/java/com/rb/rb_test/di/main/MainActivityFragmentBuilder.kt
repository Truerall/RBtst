package com.rb.rb_test.di.main

import com.rb.rb_test.di.main.fragments.MainFragmentModule
import com.rb.rb_test.di.scopes.FragmentScope
import com.rb.rb_test.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindTransactionsListFragment(): MainFragment
//
//    @FragmentScope
//    @ContributesAndroidInjector(modules = [IssueDetailsFragmentModule::class])
//    abstract fun bindTransactionsDetailsFragment(): TransactionsDetailsFragment
}