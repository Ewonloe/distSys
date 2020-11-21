package com.example.repositories;

import com.example.mapper.UserRowMapper;
import com.example.models.User;
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
public class UserRepoImp implements UserRepo{

    public UserRepoImp(NamedParameterJdbcTemplate template)
    {
        this.template = template;
    }

    private NamedParameterJdbcTemplate template;

    @Override
    public List<User> getAllUser()
    {
        return template.query("SELECT * FROM public.user", new UserRowMapper());
    }

    @Override
    public User getUser(Integer id)
    {
        final String sql = "SELECT * FROM public.user WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(sql, param, new UserRowMapper());
    }

    @Override
    public String createUser(User user)
    {
        final String sql = "INSERT INTO public.user(run, first_name, last_name, last_name2, email, password) values (:formRun, :formFirstName, :formLastName, :formLastName2, :formEmail, :userPass)";


        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("formRun", user.getRun())
                .addValue("formFirstName", user.getFirst_name())
                .addValue("formLastName", user.getLast_name())
                .addValue("formLastName2", user.getLast_name2())
                .addValue("formEmail", user.getEmail())
                .addValue("userPass", user.getPassword());

        template.update(sql, param, holder);

        return "User created successfully.";
    }

    @Override
    public String updateUser(User user)
    {
        final String sql = "UPDATE public.user SET run = :run, first_name = :first_name, last_name = :last_name, last_name2 = :last_name2, email = :email, password = :password WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("run", user.getRun())
                .addValue("first_name", user.getFirst_name())
                .addValue("last_name", user.getLast_name())
                .addValue("last_name2", user.getLast_name2())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("id", user.getId());

        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
            {
                return ps.executeUpdate();
            }
        });

        return "User updated successfully.";
    }

    public String deleteUser(User user)
    {
        final String sql = "DELETE FROM public.user WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", user.getId());

        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
            {
                return ps.executeUpdate();
            }
        });

        return "User deleted successfully.";
    }
}
