package com.example.surainrsinnasamy.makingminiproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonModelClass {

    @SerializedName("base_experience")
    private Integer base_experience;
    @SerializedName("height")
    private Integer height;
    @SerializedName("weight")
    private Integer weight;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("abilities")
    private List<Abilities> abilities;
    @SerializedName("species")
    private Species species;
    @SerializedName("sprites")
    private Sprites sprites;


    public PokemonModelClass(Integer base_experience, Integer height, Integer weight, Integer id, String name, List<Abilities> abilities, Species species, Sprites sprites) {
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.id = id;
        this.name = name;
        this.abilities = abilities;
        this.species = species;
        this.sprites = sprites;
    }

    public void setBase_experience(Integer base_experience) {
        this.base_experience = base_experience;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }


    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Species getSpecies() {
        return species;
    }

    public Integer getBase_experience() {
        return base_experience;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

}