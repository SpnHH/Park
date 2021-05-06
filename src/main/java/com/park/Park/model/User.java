package com.park.Park.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String usename;
    private final String pass;

    public User(UUID id, String usename, String pass) {
        this.id = id;
        this.usename = usename;
        this.pass = pass;
    }

    public UUID getId() {
        return id;
    }

    public String getUsename() {
        return usename;
    }

    public String getPass() {
        return pass;
    }
}
