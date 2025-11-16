package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDao extends CrudDao<Supplier,String> {
    public Supplier fetchLastSupplier() throws SQLException, ClassNotFoundException;
    public List<Supplier> fetchSuppliersByName(String searchText) throws SQLException, ClassNotFoundException;
}
