package com.example.surainrsinnasamy.makingminiproject;

import com.google.gson.annotations.SerializedName;

public class Ability {
    @SerializedName("name")
    private String name;

    public Ability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
