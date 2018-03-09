package com.template.injector.module;

import android.app.Activity;

import dagger.Module;

@Module
public class DetailModule extends ActivityModule {
    public DetailModule(Activity activity) {
        super(activity);
    }
}

