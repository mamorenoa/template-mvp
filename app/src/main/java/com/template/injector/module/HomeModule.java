package com.template.injector.module;

import android.app.Activity;

import com.template.data.FilmsRepositoryImpl;
import com.template.data.api.services.APIService;
import com.template.domain.usecases.GetFilmsUseCase;
import com.template.domain.usecases.common.InteractorExecutor;
import com.template.domain.repository.FilmsRepository;
import com.template.presentation.home.FilmsPresenter;

import dagger.Module;
import dagger.Provides;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

@Module
public class HomeModule extends ActivityModule {

    public HomeModule(Activity activity) {
        super(activity);
    }

    @Provides
    public FilmsPresenter provideHomePresenter(ThreadSpec threadSpec, InteractorExecutor executor, GetFilmsUseCase getFilmsUseCase) {
        return new FilmsPresenter(threadSpec, executor, getFilmsUseCase);
    }

    @Provides
    public GetFilmsUseCase providesHomeDataInteractor(FilmsRepository repository) {
        return new GetFilmsUseCase(repository);
    }

    @Provides
    public FilmsRepository providesMyObjectRepository(APIService api) {
        FilmsRepository repository = new FilmsRepositoryImpl(api);
        return repository;
    }
}
