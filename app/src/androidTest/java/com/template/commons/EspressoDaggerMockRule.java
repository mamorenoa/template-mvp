package com.template.commons;

import android.support.test.InstrumentationRegistry;

import com.template.TemplateApplication;
import com.template.injector.component.AppComponent;
import com.template.injector.module.AppModule;

import it.cosenonjaviste.daggermock.DaggerMockRule;

public class EspressoDaggerMockRule extends DaggerMockRule<AppComponent> {

    public EspressoDaggerMockRule() {
        super(AppComponent.class, new AppModule(getApp()));

        set(new ComponentSetter<AppComponent>() {
            @Override
            public void setComponent(AppComponent component) {
                set(new ComponentSetter<AppComponent>() {
                    @Override
                    public void setComponent(AppComponent component) {
                        getApp().getComponentsHelper().setAppComponent(component);
                    }
                });
            }
        });
    }

    private static TemplateApplication getApp() {
        return (TemplateApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
}
