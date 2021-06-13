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
    private String pass;

    public Codes(@JsonProperty("id") UUID id,
                 @JsonProperty("userId") UUID userId,
                 @JsonProperty("pass")String pass) {

        this.id = id;
        this.userId = userId;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setPass(String str){
        this.pass = str;
    }
}
