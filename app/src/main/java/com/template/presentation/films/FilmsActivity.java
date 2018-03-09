package com.template.presentation.films;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.template.R;
import com.template.domain.model.Film;
import com.template.injector.module.FilmsModule;
import com.template.presentation.common.TemplateActivity;
import com.template.presentation.navigator.Navigator;
import com.template.presentation.widget.spinner.SpinnerLoading;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class FilmsActivity extends TemplateActivity implements FilmsView {

    @Inject
    Navigator navigator;
    @Inject
    FilmsPresenter homePresenter;
    @Inject
    SpinnerLoading spinnerLoading;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homePresenter.detachView();
    }

    @Override
    protected void setModule() {
        getComponentsHelper().getAppComponent().plus(new FilmsModule(this)).inject(this);
    }

    @Override
    public int getActivityLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showError(String errorDescription) {
        Toast.makeText(this, errorDescription, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this, getString(R.string.connection_error_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDefaultError() {
        Toast.makeText(this, getString(R.string.default_error_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        spinnerLoading.show();
    }

    @Override
    public void hideLoading() {
        spinnerLoading.dismiss();
    }

    @Override
    public void showFilms(List<Film> films) {
        //TODO: Show films in recycler view
    }
}
