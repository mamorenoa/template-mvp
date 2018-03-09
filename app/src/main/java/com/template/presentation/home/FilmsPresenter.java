package com.template.presentation.home;


import com.template.domain.usecases.GetFilmsUseCase;
import com.template.domain.usecases.common.InteractorExecutor;
import com.template.domain.model.Film;
import com.template.presentation.common.BasePresenter;

import java.util.List;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

public class FilmsPresenter extends BasePresenter<FilmsView> implements GetFilmsUseCase.Callback {

    private GetFilmsUseCase getFilmsUseCase;

    public FilmsPresenter(ThreadSpec threadSpec, InteractorExecutor executor, GetFilmsUseCase getFilmsUseCase) {
        super(threadSpec, executor);
        this.getFilmsUseCase = getFilmsUseCase;
    }

    @Override
    public void onViewAttached() {
        getData();
    }

    public void getData() {
        view.showLoading();
        getFilmsUseCase.setCallbackResponse(this);
        executor.execute(getFilmsUseCase);
    }

    @Override
    public void onSuccess(List<Film> films) {
        view.hideLoading();
        view.showFilms(films);
    }

    @Override
    public void connectionError() {
        view.hideLoading();
        view.showConnectionError();
    }

    @Override
    public void error(String errorDescription) {
        view.hideLoading();
        view.showError(errorDescription);
    }

    @Override
    public void defaultError() {
        view.hideLoading();
        view.showDefaultError();
    }
}
