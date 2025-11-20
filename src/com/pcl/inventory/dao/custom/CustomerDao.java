package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer,String> {
    public List<Customer> findByFirstName(String searchText);
    public Customer getLastCustomer();
    public boolean createCustomerDetails(Connection connection, Customer customer) throws SQLException, ClassNotFoundException;

}
