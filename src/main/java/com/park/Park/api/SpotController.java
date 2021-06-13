package com.park.Park.api;

import com.park.Park.model.Spots;
import com.park.Park.model.Users;
import com.park.Park.service.SpotService;
import com.park.Park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/spot")
@RestController
public class SpotController {
    private final SpotService spotService;

    @Autowired
    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @PostMapping
    public void addSpot(@NonNull @RequestBody Spots spot){
        spotService.addSpot(spot);
    }

    @GetMapping
    public List<Spots> getSpots(){
        return spotService.getSpots();
    }

    @GetMapping(path = "/{id}")
    public Spots getSpotById(@PathVariable("id") UUID id){
        return spotService.getSpotById(id).orElse(null);
    }

    @PutMapping (path = "/{id}")
    public void updateSpot(@PathVariable("id") UUID id, @NonNull @RequestBody Spots newSpot){
        spotService.updateSpotById(id,newSpot);
    }
}
