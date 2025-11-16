package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.CrudUtill;
import com.pcl.inventory.dao.custom.ProductDao;
import com.pcl.inventory.entity.Category;
import com.pcl.inventory.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product getLastProduct() throws SQLException, ClassNotFoundException {
      ResultSet set =
              CrudUtill.execute("SELECT * FROM product ORDER BY CAST(SUBSTRING(id,6)AS UNSIGNED) DESC LIMIT 1");
      if (set.next()){
          return new Product(
                  set.getString(1),
                  set.getString(2),
                  set.getDouble(3),
                  set.getInt(4),
                  set.getString(5),
                  set.getString(6),
                  "gihan@email.com",
                  "SUP-1"

          );
      }return null;

    }

    @Override
    public List<Category> getAllCategories() throws SQLException, ClassNotFoundException {
        List<Category> categoryList=new ArrayList<>();
        ResultSet set = CrudUtill.execute("SELECT * FROM category");
        while(set.next()){
            categoryList.add(new Category(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3)
            ));
        }
        return categoryList;
    }

    @Override
    public boolean save(Product product) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Product findById(String s) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
