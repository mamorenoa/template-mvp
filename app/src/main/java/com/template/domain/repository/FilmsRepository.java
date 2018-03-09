package com.template.domain.repository;

import com.template.domain.model.Film;

import java.util.List;

public interface FilmsRepository {
    List<Film> getFilms() throws Exception;
}
