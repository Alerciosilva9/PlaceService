package com.challenge.PlaceService.Controller;

import com.challenge.PlaceService.Dtos.PlaceDto;
import com.challenge.PlaceService.Model.Place;
import com.challenge.PlaceService.Service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceService service;


    @PostMapping
    public PlaceDto createPlace(@RequestBody @Valid PlaceDto place){
        return service.createPlace(place);
    }
    @PutMapping("/{id}")
    public Place editPlace(@RequestBody @Valid PlaceDto place,@PathVariable Integer id){
        return service.editPlace(id,place);
    }

    @GetMapping()
    public List<PlaceDto> ListAll(){
        return service.findAll();

    }
    @GetMapping("/filter")
    public List<PlaceDto> ListAll(@RequestParam(name = "name") String name){
        return service.findByName(name);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findPlace(@PathVariable Integer id){
        Place finded = service.findPlace(id);
        if(finded!=null)return ResponseEntity.ok(new PlaceDto(finded));
        return ResponseEntity.notFound().build();
    }



}
