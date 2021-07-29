package com.example.demo.adoptor.gateway;

import com.example.demo.domain.Abc166;
import com.example.demo.domain.Abc166Repository;
import com.example.demo.othors.util.SqlFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class Abc166RepositoryImpl implements Abc166Repository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Abc166> fetch() {
        return jdbcTemplate.query(
                SqlFinder.get("sql/abc166/fetch.sql"), (rs, i) -> mapping(rs));
    }

    @Override
    public Optional<Abc166> find(UUID id) {
        SqlParameterSource source =
                new MapSqlParameterSource()
                        .addValue(
                                "id", id.toString());

        return jdbcTemplate.query(
                SqlFinder.get("sql/abc166/find.sql"), source, (rs, i) -> mapping(rs)).stream().findFirst();
    }

    @Override
    public void register(Abc166 abc166) {

        SqlParameterSource source =
                new MapSqlParameterSource()
                        .addValue("id", abc166.getId().toString())
                        .addValue("input", abc166.getInput())
                        .addValue("output", abc166.getOutput());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(SqlFinder.get("sql/abc166/register.sql"), source, keyHolder);
    }

    private Abc166 mapping(ResultSet rs) throws SQLException {
        return Abc166.builder().id(UUID.fromString(rs.getString("id"))).input(rs.getString("input")).output(rs.getString("output")).build();
    }
}
