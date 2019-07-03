package com.rb.rb_test.di

import com.rb.rb_test.di.ui.main.MainActivityFragmentBuilder
import com.rb.rb_test.di.scopes.ActivityScope
import com.rb.rb_test.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    /**
     * The only injected object is Repo for ViewModel, so we dont actually require any modules for both activity and fragment components.
     * Scopes are quite useless in this case, but left as an explanation, that in case of need, we can define the lifetime of or module/subcomponent and its objects
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}