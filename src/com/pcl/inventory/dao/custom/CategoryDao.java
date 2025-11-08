package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao extends CrudDao<Category,String> {
    public Category fetchLastCategory() throws SQLException, ClassNotFoundException;
    public List<Category> findCategoryByName(String name) throws SQLException, ClassNotFoundException;
}
