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

    //add a new user with id(auto-increments) - user name - password - & favorite teacher
    public User addUser(User user) {
        String sql = "insert into users (usrName, password, favTeacher) values (?, ?, ?)";
        template.update(sql, user.getUsrName(), user.getPassword(), user.getFavTeacher());
        return null;
    }

    //find and show user information via user's id
    public User findUserById(int id) {
        String sql = "select usrID, usrName, favTeacher from users where usrID = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = template.queryForObject(sql, rowMapper, id);
        return user;
    }

    //delete a user via user id
    public Boolean deleteUser(int id) {
        String sql = "delete from users where usrID = ?";
        return template.update(sql, id) > 0;
    }

    //find and edit a user's information via user's id
    public User updateUser(int id, User user) {
        String sql = "update users set usrName = ?, favTeacher = ? where usrID = ?";
        template.update(sql, user.getUsrName(), user.getFavTeacher(), user.getUsrID());
        return null;
    }

}
