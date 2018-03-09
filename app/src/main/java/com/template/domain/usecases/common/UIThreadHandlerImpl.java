package com.template.domain.usecases.common;
import android.os.Handler;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

public class UIThreadHandlerImpl implements ThreadSpec{

    private final Handler handler = new Handler();

    @Override
    public void execute(Runnable action) {
        handler.post(action);
    }
}
