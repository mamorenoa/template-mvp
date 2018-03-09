package com.template.domain.usecases.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InteractorExecutorImpl implements InteractorExecutor {

    private static final int POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;
    private static final int TIMEOUT = 15;
    private ThreadPoolExecutor threadPoolExecutor;
    private List<Future> runnableList = new ArrayList<>();

    public InteractorExecutorImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIMEOUT, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(MAX_POOL_SIZE));
    }

    public void execute(final BaseInteractor interactor) {
        execute(interactor, true);
    }

    public void execute(final BaseInteractor interactor, boolean cancelable) {
        Future future = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                interactor.executeInteractor();
            }
        });

        if (cancelable) {
            runnableList.add(future);
        }
    }

    public void stopInteractors() {
        for (Future future : runnableList) {
            future.cancel(true);
        }
        runnableList.clear();
    }
}
