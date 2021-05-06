package com.park.Park.dao;

import com.park.Park.model.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int  insertUser(UUID id, Users user);

    default int insertUser(Users user){
        UUID id = UUID.randomUUID();
        return insertUser(id,user);
    }

    List<Users> selectAllUsers();
    Optional<Users> selectUserById(UUID id);
    int deteleUserById(UUID id);
    int updateUserById(UUID id, Users user);
}
