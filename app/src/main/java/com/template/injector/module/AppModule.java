package com.template.injector.module;

import android.app.Application;

import com.template.domain.usecases.common.InteractorExecutor;
import com.template.domain.usecases.common.InteractorExecutorImpl;
import com.template.domain.usecases.common.UIThreadHandlerImpl;
import com.template.presentation.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Navigator provideNavigator() {
        Navigator navigator = new Navigator();
        return navigator;
    }

    @Provides
    @Singleton
    public ThreadSpec provideUIThreadHandler() {
        return new UIThreadHandlerImpl();
    }

    @Provides
    @Singleton
    public InteractorExecutor provideInteractorExecutor() {
        InteractorExecutor interactorExecutor = new InteractorExecutorImpl();
        return interactorExecutor;
    }

}
