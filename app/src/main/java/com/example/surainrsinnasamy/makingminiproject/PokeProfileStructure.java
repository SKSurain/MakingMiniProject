package com.example.surainrsinnasamy.makingminiproject;

public class PokeProfileStructure {

    private Integer base_experience;
    private Integer height;
    private Integer weight;
    private Integer id;
    private String name;
    private String species;
    private String sprites;

    public PokeProfileStructure(Integer base_experience, Integer height, Integer weight, Integer id, String name, String species, String sprites) {
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.id = id;
        this.name = name;
        this.species = species;
        this.sprites = sprites;
    }

    public void setBase_experience(Integer base_experience) {this.base_experience = base_experience;}

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

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setSprites(String sprites) {
        this.sprites = sprites;
    }


    public String getSprites() {
        return sprites;
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

    public String getSpecies() {
        return species;
    }
}
