package com.challenge.PlaceService.Repository;

import com.challenge.PlaceService.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    List<Place> findByName(String name);
}