package com.rb.rb_test.di

import com.rb.rb_test.data.repository.IIssuesRepository
import com.rb.rb_test.data.repository.IssuesRepository
import com.rb.rb_test.utils.rx.AppSchedulerProvider
import com.rb.rb_test.utils.rx.ISchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RBRepositoryBindingModule {
    /**
     * Repository is kept on app singleton lvl to be reused in different activities.
     * This does not mean the all the repos should be kept at this lvl.
     * But as soon as issues are the main data of app, its ok to keep it,
     * instead of creating complicated dependant modules structures / lifecycle managers.
     */
    @Singleton
    @Binds
    abstract fun bindIssuesRepository(transactionsRepository: IssuesRepository): IIssuesRepository

}