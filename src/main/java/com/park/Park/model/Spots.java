package com.park.Park.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.UUID;

public class Spots {
    @NotNull
    private final UUID id;
    @NotNull
    private final int spotNR;
    @NotNull
    private boolean available;

    public Spots(@JsonProperty("id") UUID id,
                 @JsonProperty("spotnr") int spotNR,
                 @JsonProperty("available")boolean available,
                 @JsonProperty("isfree")boolean isFree) {

        this.id = id;
        this.spotNR = spotNR;
        this.available = available;
    }

    public UUID getId(){
        return id;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getSpotNR (){
        return spotNR;
    }



}
