package com.park.Park.dao;

import com.park.Park.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

    int  insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id,user);
    }

    List<User> selectAllUsers();

}
