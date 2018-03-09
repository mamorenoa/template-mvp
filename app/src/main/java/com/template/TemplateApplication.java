package com.template;

import android.app.Application;

import com.template.injector.component.ComponentsHelper;

public class TemplateApplication extends Application {

    private ComponentsHelper componentsHelper;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ComponentsHelper getComponentsHelper() {
        if (componentsHelper == null) {
            componentsHelper = ComponentsHelper.createInstance(this).initialize();
        }
        return componentsHelper;
    }
}
