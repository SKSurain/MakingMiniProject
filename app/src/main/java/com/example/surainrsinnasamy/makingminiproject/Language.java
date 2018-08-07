package com.example.surainrsinnasamy.makingminiproject;

import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public Language(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
