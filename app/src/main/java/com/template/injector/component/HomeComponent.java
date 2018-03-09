package com.template.injector.component;


import com.template.injector.module.FilmsModule;
import com.template.presentation.films.FilmsActivity;
import com.template.presentation.films.FilmsPresenter;

import dagger.Subcomponent;

@Subcomponent(
        modules = {
                FilmsModule.class
        }
)
public interface HomeComponent {
        void inject(FilmsActivity activity);
        FilmsPresenter getHomePresenter();
}
