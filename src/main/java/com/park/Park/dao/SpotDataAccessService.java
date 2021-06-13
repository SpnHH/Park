package com.park.Park.dao;

import com.park.Park.model.Spots;
import com.park.Park.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Spot")
public class SpotDataAccessService implements SpotDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpotDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Spots> getSpots() {
        final String sql = "SELECT * FROM spots";
        var u = jdbcTemplate.query(sql, new SpotMapper());
        return u;
    }

    @Override
    public Optional<Spots> selectSpotById(UUID id) {
        Spots u = null;
        for ( Spots spot : getSpots()) {
            if(spot.getId().equals(id)){
                return Optional.ofNullable(spot);
            }
        }
        return Optional.ofNullable(u);
    }

    @Override
    public int updateSpotById(UUID id, Spots spot) {
        String sql = "Update spots SET available = ? WHERE id = ?";
        return jdbcTemplate.update(sql, spot.getAvailable(), id);
    }

    @Override
    public int addSpot(UUID id, Spots spot) {
        final String sql = "INSERT INTO spots (id, spotnr, available)" + "VALUES(?,?,?)";
        jdbcTemplate.update(sql, id, spot.getSpotNR(),spot.getAvailable());
        return 1;
    }


}
