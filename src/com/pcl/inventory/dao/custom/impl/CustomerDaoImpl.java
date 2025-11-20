package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.custom.CustomerDao;
import com.pcl.inventory.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> findByFirstName(String searchText) {
        return List.of();
    }

    @Override
    public Customer getLastCustomer() {
        return null;
    }

    @Override
    public boolean createCustomerDetails(Connection connection, Customer customer) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?)");
        ps.setString(1,customer.getId());
        ps.setString(2,customer.getFirstName());
        ps.setString(3,customer.getLastName());
        ps.setString(4,customer.getEmail());
        ps.setString(5,customer.getAddress1());
        ps.setString(6,customer.getAddress2());
        ps.setString(7,customer.getCity());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer findById(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
