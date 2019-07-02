package com.rb.rb_test.utils.rx;

import io.reactivex.Scheduler;

public interface ISchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}