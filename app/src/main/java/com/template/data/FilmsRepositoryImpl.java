package com.template.data;

import com.template.data.api.response.ServerFilm;
import com.template.data.api.services.APIService;
import com.template.data.exceptions.BaseException;
import com.template.domain.model.Film;
import com.template.domain.repository.FilmsRepository;

import java.util.List;

import retrofit2.Response;

public class FilmsRepositoryImpl extends BaseRepository implements FilmsRepository {

    public FilmsRepositoryImpl(APIService apiService) {
        super(apiService);
    }

    @Override
    public List<Film> getFilms() throws Exception {
        Response<List<ServerFilm>> serverResponse = executeCall(apiService.getFilms());
        List<Film> testResponse = ServerFilmsMapper.mapFilmsFromServer(serverResponse.body());
        return testResponse;
    }
}
