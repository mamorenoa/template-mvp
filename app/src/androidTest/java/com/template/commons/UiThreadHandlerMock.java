package com.template.commons;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

public class UiThreadHandlerMock implements ThreadSpec {

    @Override
    public void execute(Runnable action) {
        action.run();
    }
}
