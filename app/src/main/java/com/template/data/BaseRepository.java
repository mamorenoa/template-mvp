package com.template.data;

import com.google.gson.Gson;
import com.template.data.api.response.ServerError;
import com.template.data.api.services.APIService;
import com.template.data.exceptions.BaseException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class BaseRepository {

    protected APIService apiService;

    public BaseRepository(APIService apiService) {
        this.apiService = apiService;
    }

    public Response executeCall(Call call) throws Exception {
        Response response = call.execute();
        if (response == null) {
            throw new IOException();
        } else if (!response.isSuccessful()) {
            String errorBody = response.errorBody().string();
            ServerError[] serverErrorList = new Gson().fromJson(errorBody, ServerError[].class);
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < serverErrorList.length; i++) {
                ServerError serverError = serverErrorList[i];
                stringBuffer.append(serverError.getMessage());
                if (i < serverErrorList.length - 1) {
                    stringBuffer.append("\n");
                }
            }
            throw new BaseException(stringBuffer.toString());
        } else {
            return response;
        }
    }
}
