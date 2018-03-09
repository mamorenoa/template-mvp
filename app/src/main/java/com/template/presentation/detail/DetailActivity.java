package com.template.presentation.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.template.R;
import com.template.injector.module.DetailModule;
import com.template.presentation.common.TemplateActivity;

public class DetailActivity extends TemplateActivity {

    public static final String KEY_DETAIL = "com.template.presentation.detail.KEY_DETAIL";

    private DetailBundle detailParams;

    public static Intent buildIntent(Context context, DetailBundle detailBundle) {
        Intent intentCalendar = new Intent(context, DetailActivity.class);
        intentCalendar.putExtra(KEY_DETAIL, detailBundle);
        return intentCalendar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailParams = (DetailBundle) getIntent().getExtras().getSerializable(KEY_DETAIL);
        initUi();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void setModule() {
        getComponentsHelper().getAppComponent().plus(new DetailModule(this)).inject(this);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_detail;
    }

    private void initUi() {

    }
}
