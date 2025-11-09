package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;

import java.sql.SQLException;

public interface ProductBo extends SuperBo {
    public String getLastProductID() throws SQLException, ClassNotFoundException;
}
