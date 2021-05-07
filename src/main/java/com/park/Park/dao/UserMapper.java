package com.park.Park.dao;

import com.park.Park.model.Users;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rn ) throws SQLException{
        var userId = UUID.fromString(rs.getString("id"));
        var username = rs.getString("username");
        var pass = rs.getString("pass");
        Users user = new Users(userId,username,pass);

        return user;
    }

}
