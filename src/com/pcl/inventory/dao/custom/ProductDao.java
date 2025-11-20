package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.Category;
import com.pcl.inventory.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends CrudDao<Product,String> {
    public Product getLastProduct() throws SQLException, ClassNotFoundException;


}
