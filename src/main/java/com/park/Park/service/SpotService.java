package com.park.Park.service;

import com.park.Park.dao.CodeDao;
import com.park.Park.dao.SpotDao;
import com.park.Park.model.Codes;
import com.park.Park.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpotService {
    private final SpotDao spotDao;

    @Autowired
    public SpotService(@Qualifier("Spot")SpotDao spotDao) {
        this.spotDao = spotDao;
    }

    public Optional<Spots> getSpotById(UUID userId){
        return spotDao.selectSpotById(userId);

    }
    public List<Spots> getSpots(){
        return spotDao.getSpots();
    }

    public int updateSpotById(UUID Id , Spots spot){
        return spotDao.updateSpotById(Id, spot);
    }

    public int addSpot(Spots spot){
        return spotDao.addSpot(spot);
    }

}