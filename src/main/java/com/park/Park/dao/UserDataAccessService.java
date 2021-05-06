package com.park.Park.dao;

import com.park.Park.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class UserDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUsername(), user.getPass()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }
}
