package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.custom.UserDao;
import com.pcl.inventory.db.DbConnection;
import com.pcl.inventory.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List findByName(String name) {
        return List.of();
    }

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO  user VALUES(?,?,?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getDisplayName());
        ps.setString(4,user.getContact());
        ps.setString(5,user.getPassword());
       return ps.executeUpdate()>0;

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
