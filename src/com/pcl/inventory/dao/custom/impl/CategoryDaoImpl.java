package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.CrudUtill;
import com.pcl.inventory.dao.custom.CategoryDao;
import com.pcl.inventory.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public boolean update(Category category) throws SQLException, ClassNotFoundException {
      return  CrudUtill.execute("UPDATE category SET name=?,description=? WHERE id=?",
                category.getName(),
                category.getDescription(),
                category.getId()
                );
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

    @Override
    public Category fetchLastCategory() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtill.execute(
                "SELECT * FROM category ORDER BY CAST(SUBSTRING(id,5)AS UNSIGNED)DESC LIMIT 1"
        );
        if (set.next()) {
            return new Category(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3)
            );

        }
        return null;
    }

    @Override
    public List<Category> findCategoryByName(String name) throws SQLException, ClassNotFoundException {
       List<Category>categoryList=new ArrayList<>();
        ResultSet set = CrudUtill.execute("SELECT * FROM category WHERE name LIKE ?",
                name

        );
        while (set.next()) {
            categoryList.add(new Category(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3)
            ));

        }
        return  categoryList;
    }
}
