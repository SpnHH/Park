package com.park.Park.dao;

import com.park.Park.model.Spots;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SpotMapper implements RowMapper<Spots> {

    @Override
    public Spots mapRow(ResultSet rs, int rn ) throws SQLException{
        var spotId = UUID.fromString(rs.getString("id"));
        var spotNR = rs.getInt("spotnr");
        var available = rs.getBoolean("available");
        var isfree = rs.getBoolean("isfree");
        Spots spot= new Spots(spotId,spotNR,available,isfree);

        return spot;
    }

}
