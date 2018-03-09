package com.template.injector.component;

import com.template.injector.module.FilmDetailModule;
import com.template.presentation.detail.DetailActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = {
                FilmDetailModule.class
        }
)
public interface DetailComponent {
    void inject(DetailActivity activity);
}
