package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.CrudUtill;
import com.pcl.inventory.dao.custom.UserDao;
import com.pcl.inventory.db.DbConnection;
import com.pcl.inventory.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List findByName(String name) {
        return List.of();
    }

    @Override
    public User findByEmail(String email) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtill.execute("SELECT * FROM user WHERE email=?", email);
        if(set.next()){
            return new User(
                   set.getString(1),
                   set.getString(2),
                   set.getString(3),
                   set.getString(4),
                   set.getString(5)
            );
        }
        return null;

    }

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {

      return   CrudUtill.execute("INSERT INTO user VALUES(?,?,?,?,?)",user.getId(),user.getEmail(),user.getDisplayName(),user.getContact(),user.getPassword());

    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public String findById(String s) {
        return "";
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
