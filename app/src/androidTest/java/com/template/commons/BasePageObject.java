package com.template.commons;

import android.support.test.espresso.ViewInteraction;

import com.template.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class BasePageObject {
    public ViewInteraction getSpinnerLoading(){
        return onView(withId(R.id.spinnerProgress));
    }
}
