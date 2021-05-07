package com.park.Park.dao;

import com.park.Park.model.Codes;

import java.util.Optional;
import java.util.UUID;

public interface CodeDao {

    int generateCode(UUID id, Codes code);
    default  int generateCode(Codes code){
        return generateCode(UUID.randomUUID(),code);
    }

    int deleteCode(UUID userId);
    Optional<Codes> getCodeByUserId(UUID userId);

}
