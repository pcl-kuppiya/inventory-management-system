package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.custom.CustomerContactDao;
import com.pcl.inventory.entity.CustomerContact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerContactDaoImpl implements CustomerContactDao {
    @Override
    public boolean save(CustomerContact customerContact) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerContact customerContact) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerContact findById(Integer integer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CustomerContact> findAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean createCustomerContact(Connection connection, CustomerContact customerContact) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO customer_contact (contact,customer_id) VALUES (?,?)");
        ps.setString(1,customerContact.getContact());
        ps.setString(2,customerContact.getCustomerId());
        return ps.executeUpdate() > 0;
    }
}
