package com.rb.rb_test.di

import com.rb.rb_test.utils.rx.AppSchedulerProvider
import com.rb.rb_test.utils.rx.ISchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class MUAppBindingModule {
//    @Singleton
//    @Named("mock")
//    @Binds
//    abstract fun bindTransactionsRepositoryMock(transactionsRepositoryMock: TransactionsRepositoryMock): ITransactionsRepository
//
//    @Singleton
//    @Named("debug")
//    @Binds
//    abstract fun bindTransactionsRepositoryDebug(transactionsRepository: TransactionsRepository): ITransactionsRepository
//
//    @Singleton
//    @Named("release")
//    @Binds
//    abstract fun bindTransactionsRepositoryRelease(transactionsRepository: TransactionsRepository): ITransactionsRepository

    @Singleton
    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider
}