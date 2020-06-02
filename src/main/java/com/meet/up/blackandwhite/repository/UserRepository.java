package com.meet.up.blackandwhite.repository;

import com.meet.up.blackandwhite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> listAll(){
        return new ArrayList<>(jdbcTemplate.query("SELECT * FROM User",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("password")
                )));
    }

    public int save(User user){
        return jdbcTemplate.update("insert into User(userName,password) values(?,?)",user.getUserName(),user.getPassword());
    }


}
