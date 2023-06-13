package com.challenge.PlaceService.Dtos;

import com.challenge.PlaceService.Model.Place;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;


public class PlaceDto {
    @NotNull
    private String name;
    @NotNull
    private String slug;
    @NotNull
    private String city;
    @NotNull
    private String state;

    public PlaceDto(Place place){
        this.name = place.getName();
        this.city = place.getCity();
        this.slug = place.getSlug();
        this.state = place.getState();
    }

    public PlaceDto(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
