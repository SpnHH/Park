package com.park.Park.dao;

import com.park.Park.model.Codes;
import com.park.Park.model.Spots;
import com.park.Park.model.Users;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

public interface SpotDao {

    List<Spots> getSpots();
    Optional<Spots> selectSpotById(UUID id);
    public int updateSpotById(UUID id, Spots spot);
    public int addSpot(UUID id, Spots spot);

    default int addSpot(Spots spots){
        return addSpot(UUID.randomUUID(), spots);
    }
}
