package com.template.injector.component;

import android.app.Application;

import com.template.data.api.services.APIService;
import com.template.domain.usecases.common.InteractorExecutor;
import com.template.injector.module.AppModule;
import com.template.injector.module.FilmDetailModule;
import com.template.injector.module.FilmsModule;
import com.template.injector.module.NetworkModule;
import com.template.presentation.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Component;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class}
)
public interface AppComponent {

    //Submodules
    HomeComponent plus(FilmsModule module);

    DetailComponent plus(FilmDetailModule module);

    //App general modules
    Application getApplication();

    Navigator getNavigator();

    InteractorExecutor getInteractorExecutor();

    ThreadSpec getUIThreadHandler();

    APIService getApiService();
}
