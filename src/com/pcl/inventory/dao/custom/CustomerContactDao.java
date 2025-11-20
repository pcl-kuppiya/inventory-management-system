package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.CustomerContact;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerContactDao  extends CrudDao<CustomerContact,Integer> {
    public boolean createCustomerContact(Connection connection, CustomerContact customerContact) throws SQLException;

}
