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
        //DB.add(new Users(id, user.getUsername(), user.getPass()));
        final String sql = "INSERT INTO users (id, username, pass)" + "VALUES(?,?,?)";
        jdbcTemplate.update(sql, id, user.getUsername(),user.getPass());
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
        final String sql = "DELETE FROM users WHERE id=?";
        jdbcTemplate.update(sql, id);
        return 1;
    }

    @Override
    public int updateUserById(UUID id, Users user) {
        String sql = "Update users SET pass = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getPass(), id);
    }
}
