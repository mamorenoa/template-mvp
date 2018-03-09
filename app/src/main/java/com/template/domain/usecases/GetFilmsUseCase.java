package com.template.domain.usecases;

import com.template.domain.usecases.common.BaseInteractor;
import com.template.domain.usecases.common.BaseInteractorCallback;
import com.template.domain.model.Film;
import com.template.domain.repository.FilmsRepository;

import java.util.List;

public class GetFilmsUseCase extends BaseInteractor<GetFilmsUseCase.Callback> {

    private FilmsRepository repository;

    public interface Callback extends BaseInteractorCallback {
        void onSuccess(List<Film> films);
    }

    public GetFilmsUseCase(FilmsRepository repository) {
        super();
        this.repository = repository;
    }

    public void setCallbackResponse(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void doIt() throws Exception {
        final List<Film> films = this.repository.getFilms();
        callback.onSuccess(films);
    }
}
