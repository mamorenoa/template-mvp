package com.template.presentation.navigator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.template.presentation.common.TemplateActivity;
import com.template.presentation.detail.DetailActivity;
import com.template.presentation.detail.DetailBundle;

import javax.inject.Inject;
import javax.inject.Singleton;

public class Navigator {

    public interface From {
        int NOT_FOLLOW = -1;
        //int LOGIN = 1;
    }

    public Navigator() {
    }

    public void navigate(Context context, Class<? extends TemplateActivity> templateActivityClass) {
        navigate(context, templateActivityClass, From.NOT_FOLLOW, null);
    }

    public void navigate(Context context, Class<? extends TemplateActivity> templateActivityClass,
                          Bundle params) {
        navigate(context, templateActivityClass, From.NOT_FOLLOW, params);
    }

    public void navigate(Context context, Class<? extends TemplateActivity> templateActivityClass, int requestCode) {
        navigate(context, templateActivityClass, requestCode, null);
    }

    public void navigate(@NonNull Context context, @NonNull Class<? extends TemplateActivity> templateActivityClass, int requestCode, @Nullable Bundle params) {
        ((TemplateActivity) context).startActivityForResult(new Intent(context, templateActivityClass), requestCode, params);
    }

    public void navigate(@NonNull Context context, int requestCode, @Nullable Intent intent) {
        ((TemplateActivity) context).startActivityForResult(intent, requestCode);
    }

    public void navigateToDetail(Context context, DetailBundle detailBundle) {
        Intent iDetail = DetailActivity.buildIntent(context, detailBundle);
        navigate(context, From.NOT_FOLLOW, iDetail);
    }
}
