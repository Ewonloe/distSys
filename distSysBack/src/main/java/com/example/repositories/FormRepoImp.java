package com.example.repositories;

import com.example.mapper.FormRowMapper;
import com.example.models.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class FormRepoImp implements FormRepo{

    public FormRepoImp(NamedParameterJdbcTemplate template)
    {
        this.template = template;
    }

    private NamedParameterJdbcTemplate template;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<Form> getAllForm()
    {
        return template.query("SELECT * FROM form", new FormRowMapper());
    }

    @Override
    public Form getForm(Integer id)
    {
        final String sql = "SELECT * FROM form WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(sql, param, new FormRowMapper());
    }

    @Override
    public String createForm(Form form)
    {
        final String sql = "INSERT INTO form(run, first_name, last_name, last_name2, reason_id, email, emitted_at, expired_at) values (:formRun, :formFirstName, :formLastName, :formLastName2, :formReason_id, :formEmail, :formEmittedAt, :formExpiredAt)";
        final String anotherSql = "SELECT description FROM reason WHERE id = :id";
        final String auxSql = "SELECT duration FROM reason WHERE id = :id";

        SqlParameterSource auxParam = new MapSqlParameterSource()
                .addValue("id", form.getReason_id());

        String description = template.queryForObject(anotherSql, auxParam, String.class);
        Time duration = template.queryForObject(auxSql, auxParam, Time.class);

        KeyHolder holder = new GeneratedKeyHolder();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp later = new Timestamp(System.currentTimeMillis() + duration.getTime());


        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(form.getEmail());
        msg.setSubject("Notificación de permiso generado");
        msg.setText("Se ha generado un permiso en nuestra base de datos con la siguiente información:\n" +
                "RUN: " + form.getRun() + "\n" +
                "Nombre: " + form.getFirst_name() + "\n" +
                "Primer Apellido: " + form.getLast_name() + "\n" +
                "Segundo Apellido: " + form.getLast_name2() + "\n" +
                "Razón: " + description + "\n" +
                "Correo electrónico: " + form.getEmail() + "\n" +
                "Emitido a las: " + now.toString() + "\n" +
                "Expira a las: " + later.toString());

        javaMailSender.send(msg);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("formRun", form.getRun())
                .addValue("formFirstName", form.getFirst_name())
                .addValue("formLastName", form.getLast_name())
                .addValue("formLastName2", form.getLast_name2())
                .addValue("formReason_id", form.getReason_id())
                .addValue("formEmail", form.getEmail())
                .addValue("formEmittedAt", now)
                .addValue("formExpiredAt", later);

        template.update(sql, param, holder);

        return "Form created successfully.";
    }

    @Override
    public String updateForm(Form form)
    {
        final String sql = "UPDATE form SET run = :run, first_name = :firstName, last_name = :lastName, last_name2 = :lastName2, reason_id = :reason_id, email = :email, emitted_at = :emittedAt, expired_at = :expiredAt WHERE id = :id";

        if (form.getEmitted_at() == null)
        {
            final String auxSql = "SELECT emitted_at FROM form WHERE id = :id";

            SqlParameterSource auxParam = new MapSqlParameterSource()
                    .addValue("id", form.getId());

            form.setEmitted_at(template.queryForObject(auxSql, auxParam, Timestamp.class));
        }

        if (form.getExpired_at() == null)
        {
            final String auxSql = "SELECT expired_at FROM form WHERE id = :id";

            SqlParameterSource auxParam = new MapSqlParameterSource()
                    .addValue("id", form.getId());

            form.setExpired_at(template.queryForObject(auxSql, auxParam, Timestamp.class));
        }

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("run", form.getRun())
                .addValue("firstName", form.getFirst_name())
                .addValue("lastName", form.getLast_name())
                .addValue("lastName2", form.getLast_name2())
                .addValue("reason_id", form.getReason_id())
                .addValue("email", form.getEmail())
                .addValue("emittedAt", form.getEmitted_at())
                .addValue("expiredAt", form.getExpired_at())
                .addValue("id", form.getId());

        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
            {
                return ps.executeUpdate();
            }
        });

        return "Form updated successfully.";
    }

    public String deleteForm(Form form)
    {
        final String sql = "DELETE FROM form WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", form.getId());

        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
            {
                return ps.executeUpdate();
            }
        });

        return "Form deleted successfully.";
    }






}
