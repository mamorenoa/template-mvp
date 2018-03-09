package com.template.presentation.common;

public interface TemplateView {
    void showLoading();

    void hideLoading();

    void showConnectionError();

    void showDefaultError();

    void showError(String errorDescription);
}
