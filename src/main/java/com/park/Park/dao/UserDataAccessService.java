package com.park.Park.dao;

import com.park.Park.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.*;

@Repository("postgre")
public class UserDataAccessService implements UserDao {
    private static List<Users> DB = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, Users user) {
        DB.add(new Users(id, user.getUsername(), user.getPass()));
        return 1;
    }

    @Override
    public List<Users> selectAllUsers() {
        final String sql = "SELECT id, username, pass FROM users";
            var u = jdbcTemplate.query(sql, new UserMapper());
            return u;
    }
    @Override
    public Optional<Users> selectUserById(UUID id) {
        final String sql = "SELECT id, username , password FROM user WHERE id = " + id.toString();
       // var u = jdbcTemplate.queryForObject(sql, new UserMapper());
        Users u = null;
        for ( Users user : selectAllUsers()) {
            if(user.getId().equals(id)){
                return Optional.ofNullable(user);
            }
        }
        return Optional.ofNullable(u);
    }

    @Override
    public int deteleUserById(UUID id) {
        Optional<Users> user = selectUserById(id);
        if(user.isEmpty()){
            return 0;
        }
        DB.remove(user.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID id, Users user) {
        return selectUserById(id)
                .map(u -> {
                    int indexOfUserToUpdate = DB.indexOf(u);
                    if(indexOfUserToUpdate >= 0){
                        DB.set(indexOfUserToUpdate, new Users(id, user.getUsername(), user.getPass()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
