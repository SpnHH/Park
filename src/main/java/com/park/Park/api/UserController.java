package com.park.Park.api;

import com.park.Park.model.Users;
import com.park.Park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@NonNull @RequestBody Users user){
        userService.addUser(user);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping(path = "/{id}")
    public Users getPersonById(@PathVariable("id") UUID id){
        return userService.getUserById(id).orElse(null);
    }

    @DeleteMapping (path = "/{id}")
    public void deleteUserById(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }

    @PutMapping (path = "/{id}")
    public void updateUser(@PathVariable("id") UUID id, @NonNull @RequestBody Users newUser){
        userService.updateUser(id,newUser);
    }
}
