package com.park.Park.dao;

import com.park.Park.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUsename(), user.getPass()));
        return 1;
    }
}
