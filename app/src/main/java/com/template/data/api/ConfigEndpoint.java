package com.template.data.api;

public class ConfigEndpoint {
    private String environment = "dev";
    private String baseUrl;
    private String version = "v1/";
    private String language = "ES/";

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getVersion() {
        return version;
    }

    public String getLanguage() {
        return language;
    }
}
