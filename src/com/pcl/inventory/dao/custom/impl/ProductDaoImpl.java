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
    public boolean save(Product product) throws SQLException, ClassNotFoundException {
     return CrudUtill.execute("INSERT INTO product VALUES(?,?,?,?,?,?,?,?)",
                product.getId(),
                product.getName(),
                product.getUnitPrice(),
              product.getStock(),
              product.getDescription(),
              product.getCategory(),
              product.getUser(),
              product.getSupplier()
              );
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
     return   CrudUtill.execute("UPDATE product SET name=?,unit_price=?,stock=?,description=?,category=?,supplier_id=?,user_id=? WHERE id=?",
               product.getName(),
               product.getUnitPrice(),
               product.getStock(),
               product.getDescription(),
               product.getCategory(),
               product.getUser()
               );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;//yet to implement
    }

    @Override
    public Product findById(String s) throws SQLException, ClassNotFoundException {
      ResultSet set= CrudUtill.execute("SELECT * FROM supplier WHERE id=?",s);
      if (set.next()){
          return new Product(

                          set.getString(1),
                          set.getString(2),
                          set.getDouble(3),
                          set.getInt(4),
                          set.getString(5),
                          set.getString(6),
                          set.getString(7),
                          set.getString(8)

          );
      }
      return null;
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        ResultSet set = CrudUtill.execute("SELECT * FROM product");
        while (set.next()){
            products.add(
                    new Product(

                            set.getString(1),
                            set.getString(2),
                            set.getDouble(3),
                            set.getInt(4),
                            set.getString(5),
                            set.getString(6),
                            set.getString(7),
                            set.getString(8)

                    )
            );
        }
        return products;

    }
}
