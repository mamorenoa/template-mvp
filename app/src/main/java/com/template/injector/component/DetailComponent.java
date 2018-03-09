package com.template.injector.component;

import com.template.injector.module.DetailModule;
import com.template.presentation.detail.DetailActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = {
                DetailModule.class
        }
)
public interface DetailComponent {
    void inject(DetailActivity activity);
}
