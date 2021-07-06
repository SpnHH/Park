package com.park.Park.dao;

import com.park.Park.model.Codes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        final String sql = "INSERT INTO codes (id, userId, pass)" + "VALUES(?,?,?)";
        jdbcTemplate.update(sql, id, code.getUserId(),code.getPass());
        return 1;
    }

    @Override
    public int deleteCode(UUID userId) {
        final String sql ="DELETE FROM codes WHERE userId=?";
        return jdbcTemplate.update(sql, userId);
    }

    @Override
    public Optional<Codes> getCodeByUserId(UUID userId) {
        final String sql ="SELECT * FROM codes";
        var codes = jdbcTemplate.query(sql,new CodeMapper());
        for(var code:codes){
            if(code.getUserId().equals(userId)){
                return Optional.ofNullable(code);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Codes> getCodes() {
        final String sql = "SELECT * FROM codes";
        var c = jdbcTemplate.query(sql, new CodeMapper());
        return c;
    }
}
