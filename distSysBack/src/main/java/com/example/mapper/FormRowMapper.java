package com.example.mapper;


import com.example.models.Form;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormRowMapper implements RowMapper<Form> {

    @Override
    public Form mapRow(ResultSet rs, int arg1) throws SQLException{
        Form form = new Form();
        form.setEmail(rs.getString("email"));
        form.setFirst_name(rs.getString("first_name"));
        form.setId(rs.getBigDecimal("id"));
        form.setLast_name(rs.getString("last_name"));
        form.setLast_name2(rs.getString("last_name2"));
        form.setReason_id(rs.getBigDecimal("reason_id"));
        form.setRun(rs.getString("run"));
        form.setEmitted_at(rs.getTimestamp("emitted_at"));
        form.setExpired_at(rs.getTimestamp("expired_at"));

        return form;
    }
}
