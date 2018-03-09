package com.template.injector.module;

import android.app.Activity;

import dagger.Module;

@Module
public class FilmDetailModule extends ActivityModule {
    public FilmDetailModule(Activity activity) {
        super(activity);
    }
}

