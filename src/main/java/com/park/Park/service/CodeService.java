package com.park.Park.service;

import com.park.Park.dao.CodeDao;
import com.park.Park.model.Codes;
import com.park.Park.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CodeService {
    private final CodeDao codeDao;

    @Autowired
    public CodeService(@Qualifier("Code")CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public int generateCode(UUID userId){
        return codeDao.generateCode(userId);
    }

    public Optional<Codes> getCodeByUserId(UUID userId){
        return codeDao.getCodeByUserId(userId);
    }
    public List<Codes> getCodes(){
        return codeDao.getCodes();
    }

    public int deleteCode(UUID userId){
        return codeDao.deleteCode(userId);
    }

}