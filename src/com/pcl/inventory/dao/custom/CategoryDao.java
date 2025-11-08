package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.Category;

import java.sql.SQLException;

public interface CategoryDao extends CrudDao<Category,String> {
    public Category fetchLastCategory() throws SQLException, ClassNotFoundException;
}
