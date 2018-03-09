package com.template.injector.module;

import android.app.Activity;

import com.template.presentation.widget.spinner.SpinnerLoading;
import com.template.presentation.widget.spinner.SpinnerLoadingImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return this.activity;
    }

    @Provides
    public SpinnerLoading provideSpinnerLoading() {
        return new SpinnerLoadingImpl(activity);
    }
}
