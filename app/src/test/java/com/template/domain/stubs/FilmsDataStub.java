package com.template.domain.stubs;

import com.template.domain.model.Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmsDataStub {

    //TODO:
    public static List<Film> getFilmsServiceData() {
        List<Film> films = new ArrayList<>();
        Film film1 = new Film("1", "El Padrino", "Francis Ford Coppola");
        films.add(film1);
        return films;
    }
}
