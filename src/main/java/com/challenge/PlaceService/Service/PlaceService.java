package com.challenge.PlaceService.Service;

import com.challenge.PlaceService.Dtos.PlaceDto;
import com.challenge.PlaceService.Model.Place;
import com.challenge.PlaceService.Repository.PlaceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository repository;


    public Place createPlace(PlaceDto dto){
        Place place = new Place(dto);
        place.setCreatedAt(LocalDateTime.now());
        return repository.save(place);
    }

    public List<PlaceDto> findAll(){
        List<Place> listPlace = repository.findAll();
        return listPlace.stream().map((x)-> new PlaceDto(x)).collect(Collectors.toList());
    }
    public List<PlaceDto> findByName(String name){
        return repository.findByName(name).stream().map((x)->new PlaceDto(x)).collect(Collectors.toList());
    }


    public Place editPlace(Integer id, PlaceDto place){
        Place findPlace = repository.findById(id).orElse(null);
        if(findPlace==null)return null;
        findPlace.setUpdatedAt(LocalDateTime.now());
        findPlace.setName(place.getName());
        findPlace.setCity(place.getCity());
        findPlace.setState(place.getState());
        return repository.save(findPlace);
    }

    public Place findPlace(Integer id){
        Place specificPlace = repository.findById(id).orElse(null);
        return specificPlace;
    }


}
