package com.template.data.api.response;

import com.google.gson.annotations.SerializedName;

public class ServerError {

    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
}
