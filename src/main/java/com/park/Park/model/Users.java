package com.park.Park.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.UUID;

public class Users {
    private final UUID id;
    @NotNull
    private final String username;
    @NotNull
    private final String pass;

    public Users(@JsonProperty("id") UUID id,
                 @JsonProperty("username")String username,
                 @JsonProperty("pass")String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
