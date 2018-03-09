package com.template.data.api.response;

import com.google.gson.annotations.SerializedName;

public class ServerFilm extends BaseServerResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("director")
    private String director;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}

