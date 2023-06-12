package com.challenge.PlaceService.Service;

import com.challenge.PlaceService.Model.Place;
import com.challenge.PlaceService.Repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository repository;


    public Place createPlace(Place place){
        Place newPlace = repository.save(place);
        return newPlace;
    }

    public List<Place> findAll(){
        return repository.findAll();
    }
    public List<Place> findByName(String name){
        return repository.findByName(name);
    }

    public Place editPlace(Integer id, Place place){
        Place findPlace = repository.findById(id).orElse(null);
        if(findPlace==null)return null;
        findPlace.setName(place.getName());
        findPlace.setCity(place.getCity());
        return repository.save(findPlace);
    }

    public Place findPlace(Integer id){
        Place specificPlace = repository.findById(id).orElse(null);
        return specificPlace;
    }


}
