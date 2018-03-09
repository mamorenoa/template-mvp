package com.template.domain.usecases;

import com.template.data.exceptions.ConnectionException;
import com.template.data.exceptions.DefaultException;
import com.template.domain.common.UiThreadHandlerMock;
import com.template.domain.model.Film;
import com.template.domain.repository.FilmsRepository;
import com.template.domain.stubs.FilmsDataStub;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class GetFilmsUseCaseTest {

    //Class under test
    GetFilmsUseCase getFilmsUseCase;

    @Mock
    FilmsRepository dataRepository;

    @Mock
    private GetFilmsUseCase.Callback callback;

    private ThreadSpec threadSpec;
    private List<Film> testServiceData;
    private String param;

    @Before
    public void setup() {
        initValues();
        initInteractor();
        initStubs();
    }

    private void initValues() {
        param = "param1";
    }

    private void initInteractor() {
        threadSpec = new UiThreadHandlerMock();
        getFilmsUseCase = new GetFilmsUseCase(dataRepository);
        getFilmsUseCase.setCallbackResponse(callback);
    }

    private void initStubs() {
        testServiceData = FilmsDataStub.getFilmsServiceData();
    }

    @Test
    public void testExecute() throws Exception {
        getFilmsUseCase.executeInteractor();
        verify(dataRepository).getFilms();
    }

    @Test
    public void testGetSampleDataRequest() throws Exception {
        doReturn(testServiceData).when(dataRepository).getFilms();
        getFilmsUseCase.executeInteractor();
        verify(dataRepository).getFilms();
    }

    @Test
    public void testGetSampleDataError() throws Exception {
        doThrow(DefaultException.class).when(dataRepository).getFilms();
        getFilmsUseCase.executeInteractor();
        verify(callback).defaultError();
    }

    @Test
    public void testGetSampleDataErrorConnection() throws Exception {
        doThrow(ConnectionException.class).when(dataRepository).getFilms();
        getFilmsUseCase.executeInteractor();
        verify(callback).connectionError();
    }

    @Test
    public void testGetSampleDataSuccess() throws Exception {
        doReturn(testServiceData).when(dataRepository).getFilms();
        getFilmsUseCase.executeInteractor();
        verify(callback).onSuccess(testServiceData);
    }
}
