package com.template.data.common;

import java.util.Map;
import java.util.TreeMap;

import okhttp3.Headers;
import okhttp3.mockwebserver.MockResponse;

public class MockApiReponse {

    interface ResponseCode {
        int SUCCESS = 200;
        int ERROR = 400;
    }

    private static Headers getHeaders() {
        Map<String, String> mapHeader = new TreeMap<>();
        mapHeader.put("Content-Type", "application/json; charset=utf-8");
        mapHeader.put("Cache-Control", "no-cache");
        return Headers.of(mapHeader);
    }

    public static MockResponse serviceGetFilmsSuccess() {
        return new MockResponse().setHeaders(getHeaders())
                .setBody(ResponseStubs.getResponseLoginOk())
                .setResponseCode(ResponseCode.SUCCESS);
    }

    public static MockResponse serviceGetFilmsError() {
        return new MockResponse().setHeaders(getHeaders())
                .setBody(ResponseStubs.getResponseLoginWithError())
                .setResponseCode(ResponseCode.ERROR);
    }
}
