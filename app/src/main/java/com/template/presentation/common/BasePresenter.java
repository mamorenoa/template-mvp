package com.template.presentation.common;

import com.template.domain.usecases.common.InteractorExecutor;

import me.panavtec.threaddecoratedview.views.ThreadSpec;
import me.panavtec.threaddecoratedview.views.ViewInjector;

public abstract class BasePresenter<V> {

    protected InteractorExecutor executor;
    protected V view;
    private ThreadSpec threadSpec;

    public BasePresenter(ThreadSpec threadSpec, InteractorExecutor executor) {
        this.threadSpec = threadSpec;
        this.executor = executor;
    }

    public void attachView(V view) {
        this.view = ViewInjector.inject(view, threadSpec);
        onViewAttached();
    }

    public void detachView() {
        if (view != null) {
            ViewInjector.nullObjectPatternView(view);
        }
    }

    public abstract void onViewAttached();
}