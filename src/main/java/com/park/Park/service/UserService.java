package com.park.Park.service;

import com.park.Park.dao.UserDao;
import com.park.Park.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgre") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(Users user){
        return userDao.insertUser(user);
    }

    public List<Users> getAllUser(){
        return userDao.selectAllUsers();
    }
    public Optional<Users> getUserById(UUID id){
        return userDao.selectUserById(id);
    }
    public int deleteUser(UUID id){
        return userDao.deteleUserById(id);
    }
    public int updateUser(UUID id, Users newUser){
        return userDao.updateUserById(id, newUser);
    }
}
