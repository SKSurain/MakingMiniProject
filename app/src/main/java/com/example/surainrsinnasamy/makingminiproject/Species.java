package com.example.surainrsinnasamy.makingminiproject;

import com.google.gson.annotations.SerializedName;

public class Species {
    @SerializedName("name")
    private String name;

    public Species(String name) {

        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
