package com.spring_boot.spring_db_fun.repository;

import com.spring_boot.spring_db_fun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*the class provides the mechanism for
storage, retrieval, update, delete and
search operation on objects @Repository*/
@Repository
public class UserRepo {

    //dependency injection of JdbcTemplate to run SQL-queries
    @Autowired
    private JdbcTemplate template;

    //retrieve the user id - user name - & favorite teacher from "users" table
    public List<User> fetchAll() {
        String sql = "select usrID, usrName, favTeacher from users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);
    }

    public User addUser(User user) {
        return null;
    }

    public User findUserById(int id) {
        return null;
    }

    public Boolean deleteUser(int id) {
        return null;
    }

    public User updateUser(int id, User user) {
        return null;
    }

}
