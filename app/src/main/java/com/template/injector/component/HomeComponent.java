package com.template.injector.component;


import com.template.injector.module.HomeModule;
import com.template.presentation.home.FilmsActivity;
import com.template.presentation.home.FilmsPresenter;

import dagger.Subcomponent;

@Subcomponent(
        modules = {
                HomeModule.class
        }
)
public interface HomeComponent {
        void inject(FilmsActivity activity);
        FilmsPresenter getHomePresenter();
}
