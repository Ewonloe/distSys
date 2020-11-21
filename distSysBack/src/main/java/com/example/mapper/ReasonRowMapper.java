package com.example.mapper;

import com.example.models.Reason;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReasonRowMapper implements RowMapper<Reason> {

    @Override
    public Reason mapRow(ResultSet rs, int arg1) throws SQLException {
        Reason reason = new Reason();
        reason.setId(rs.getBigDecimal("id"));
        reason.setDescription(rs.getString("description"));
        reason.setDuration(rs.getTime("duration"));

        return reason;
    }
}
