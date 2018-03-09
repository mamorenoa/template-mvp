package com.template.data;

import com.template.data.api.response.ServerFilm;
import com.template.domain.model.Film;

import java.util.ArrayList;
import java.util.List;

public class ServerFilmsMapper {

    public static List<Film> mapFilmsFromServer(List<ServerFilm> serverFilms) {
        List<Film> domainFilms = new ArrayList<>();
        for (ServerFilm serverFilm : serverFilms) {
            domainFilms.add(mapFilmFromServer(serverFilm));
        }
        return domainFilms;
    }

    public static Film mapFilmFromServer(ServerFilm response) {
        Film film = new Film();
        film.setId(response.getId());
        film.setName(response.getName());
        film.setDirector(response.getDirector());
        return film;
    }
}
