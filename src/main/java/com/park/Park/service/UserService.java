package com.park.Park.service;

import com.park.Park.dao.UserDao;
import com.park.Park.model.User;
import net.bytebuddy.asm.Advice;
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

    public int addUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> getAllUser(){
        return userDao.selectAllUsers();
    }
    public Optional<User> getUserById(UUID id){
        return userDao.selectUserById(id);
    }
    public int deleteUser(UUID id){
        return userDao.deteleUserById(id);
    }
    public int updateUser(UUID id, User newUser){
        return userDao.updateUserById(id, newUser);
    }
}
