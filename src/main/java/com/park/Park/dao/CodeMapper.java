package com.park.Park.dao;

import com.park.Park.model.Codes;
import com.park.Park.model.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CodeMapper implements RowMapper<Codes> {

    @Override
    public Codes mapRow(ResultSet rs, int rn ) throws SQLException{
        var codeId = UUID.fromString(rs.getString("id"));
        var userId = UUID.fromString(rs.getString("userId"));
        var pass = rs.getString("password");
        Codes code= new Codes(codeId,userId,pass);

        return code;
    }

}
