package com.template.domain.usecases.common;

import com.template.data.exceptions.BaseException;

import java.net.UnknownHostException;

public abstract class BaseInteractor<I extends BaseInteractorCallback> {

    protected I callback;

    public abstract void doIt() throws Exception;

    public void executeInteractor() {
        try {
            if (!isCanceled()) {
                doIt();
            }
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
            if (!isCanceled()) {
                callback.connectionError();
            }
        } catch (BaseException e) {
            e.printStackTrace();
            if (!isCanceled()) {
                callback.error(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!isCanceled()) {
                callback.defaultError();
            }
        }
    }

    protected boolean isCanceled() {
        return Thread.currentThread().isInterrupted();
    }

    public I getCallback() {
        return callback;
    }
}
