package com.example.repositories;

import com.example.mapper.ReasonRowMapper;
import com.example.models.Reason;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReasonRepoImp implements ReasonRepo {

    public ReasonRepoImp(NamedParameterJdbcTemplate template)
    {
        this.template = template;
    }

    private NamedParameterJdbcTemplate template;

    @Override
    public List<Reason> getAllReason()
    {
        return template.query("SELECT * FROM reason", new ReasonRowMapper());
    }

    @Override
    public Reason getReason(Integer id)
    {
        final String sql = "SELECT * FROM reason WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(sql, param, new ReasonRowMapper());
    }

    @Override
    public String createReason(Reason reason)
    {
        final String sql = "INSERT INTO reason(description, duration) values (:formDescription, :formDuration)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("formDescription", reason.getDescription())
                .addValue("formDuration", reason.getDuration());

        template.update(sql, param, holder);

        return "Reason created successfully.";
    }

    @Override
    public String updateReason(Reason reason)
    {
        final String sql = "UPDATE reason SET description = :description WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("description", reason.getDescription())
                .addValue("id", reason.getId());

        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
            {
                return ps.executeUpdate();
            }
        });

        return "Reason updated successfully.";
    }

    public String deleteReason(Reason reason)
    {
        final String sql = "DELETE FROM reason WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", reason.getId());

        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
            {
                return ps.executeUpdate();
            }
        });

        return "Reason deleted successfully.";
    }
}
