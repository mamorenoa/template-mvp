package com.template.domain.usecases.common;

import com.template.domain.model.BaseModel;

public interface BaseInteractorCallback<T extends BaseModel> {
    void connectionError();

    void error(String errorDescription);

    void defaultError();
}
