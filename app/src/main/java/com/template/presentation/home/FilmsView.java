package com.template.presentation.home;

import com.template.domain.model.Film;
import com.template.presentation.common.TemplateView;

import java.util.List;

import me.panavtec.threaddecoratedview.views.qualifiers.ThreadDecoratedView;

@ThreadDecoratedView
public interface FilmsView extends TemplateView {
    void showFilms(List<Film> films);
}
