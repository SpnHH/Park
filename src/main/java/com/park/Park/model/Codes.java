package com.park.Park.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.UUID;

public class Codes {
    @NotNull
    private final UUID id;
    @NotNull
    private final UUID userId;
    @NotNull
    private String password;

    public Codes(@JsonProperty("id") UUID id,
                 @JsonProperty("userId") UUID userId,
                 @JsonProperty("password")String password) {

        this.id = id;
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setPassword(String str){
        this.password = str;
    }
}
