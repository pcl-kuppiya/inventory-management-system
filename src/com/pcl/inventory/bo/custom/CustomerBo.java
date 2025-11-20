package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;
import com.pcl.inventory.dto.request.RequestCustomerDto;

import java.sql.SQLException;

public interface CustomerBo extends SuperBo {
    public boolean createCustomer(RequestCustomerDto requestCustomerDto) throws SQLException, ClassNotFoundException;
}
