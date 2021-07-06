package com.park.Park.service;

import com.park.Park.dao.CodeDao;
import com.park.Park.model.Codes;
import com.park.Park.model.Users;
import org.aspectj.apache.bcel.classfile.Code;
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
    public int deleteCodeByCode(String code){
        List<Codes> codes = getCodes();
        for(var c: codes){
            if(c.getPass().equals(code)){
                return codeDao.deleteCode(c.getUserId());
            }
        }
        return 0;
    }
}