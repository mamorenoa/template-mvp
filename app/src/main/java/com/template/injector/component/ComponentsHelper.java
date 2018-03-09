package com.template.injector.component;

import com.template.TemplateApplication;
import com.template.injector.module.AppModule;
import com.template.injector.module.NetworkModule;

public class ComponentsHelper {

    private TemplateApplication application;

    private AppComponent appComponent;

    public static ComponentsHelper createInstance(TemplateApplication application){
        return new ComponentsHelper(application);
    }

    private ComponentsHelper(TemplateApplication application){
        this.application = application;
    }

    public ComponentsHelper initialize(){
        this.buildAppComponent();
        return this;
    }

    private void buildAppComponent(){
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(application))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent(){
        if (appComponent == null){
            initialize();
        }
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent){
        this.appComponent = appComponent;
    }
}