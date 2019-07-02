package com.rb.rb_test.di

import android.app.Application
import com.rb.rb_test.RBApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        MUAppProviderModule::class,
        MUAppBindingModule::class]
)
interface RBAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): RBAppComponent.Builder

        fun build(): RBAppComponent
    }

    fun inject(instance: RBApp)
}