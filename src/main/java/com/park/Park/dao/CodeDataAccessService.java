package com.park.Park.dao;

import com.park.Park.model.Codes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("Code")
public class CodeDataAccessService implements CodeDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CodeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int generateCode(UUID id, Codes code) {
        return 0;
    }

    @Override
    public int deleteCode(UUID userId) {
        return 0;
    }

    @Override
    public Optional<Codes> getCodeByUserId(UUID userId) {
        return Optional.empty();
    }
}
