package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.CrudUtill;
import com.pcl.inventory.dao.custom.CategoryDao;
import com.pcl.inventory.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public boolean save(Category category) throws SQLException, ClassNotFoundException {
      return  CrudUtill.execute("INSERT INTO category VALUES(?,?,?)",
                category.getId(),
                category.getName(),
                category.getDescription()
                );
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public String findById(String s) {
        return "";
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }
}
