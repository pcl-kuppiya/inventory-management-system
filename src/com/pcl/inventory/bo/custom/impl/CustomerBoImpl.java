package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.CustomerBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.CustomerContactDao;
import com.pcl.inventory.dao.custom.CustomerDao;
import com.pcl.inventory.db.DbConnection;
import com.pcl.inventory.dto.request.RequestCustomerDto;
import com.pcl.inventory.entity.Customer;
import com.pcl.inventory.entity.CustomerContact;
import com.pcl.inventory.utill.DaoType;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao= DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    CustomerContactDao customerContactDao= DaoFactory.getInstance().getDao(DaoType.CUSTOMERCONTACT);
    @Override
    public boolean createCustomer(RequestCustomerDto requestCustomerDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            boolean isDetailsCreated = customerDao.createCustomerDetails(connection, new Customer(
                    requestCustomerDto.getId(),
                    requestCustomerDto.getFirstName(),
                    requestCustomerDto.getLastName(),
                    requestCustomerDto.getEmail(),
                    requestCustomerDto.getAddress1(),
                    requestCustomerDto.getAddress2(),
                    requestCustomerDto.getCity()
            ));
            if (isDetailsCreated) {
                boolean isContactCreated = customerContactDao.createCustomerContact(connection, new CustomerContact(
                        requestCustomerDto.getContact(),
                        requestCustomerDto.getId()));
                if (isContactCreated) {
                    connection.commit();
                    return true;
                }else {
                    connection.rollback();
                    return false;
                }

            }else {
                connection.rollback();
                return false;
            }
        }catch (Exception e){
            connection.rollback();
            throw e;
        }finally {
            connection.setAutoCommit(true);
        }
    }
}
