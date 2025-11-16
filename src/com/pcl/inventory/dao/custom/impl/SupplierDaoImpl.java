package com.pcl.inventory.dao.custom.impl;

import com.pcl.inventory.dao.CrudUtill;
import com.pcl.inventory.dao.custom.SupplierDao;
import com.pcl.inventory.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
      return   CrudUtill.execute("INSERT INTO supplier VALUES(?,?,?,?,?,?,?,?,?)",
                supplier.getId(),
                supplier.getName(),
                supplier.getContactPerson(),
                supplier.getContactNumber(),
                supplier.getEmail(),
                supplier.getAddress1(),
                supplier.getAddress2(),
                supplier.getCity(),
                supplier.getCountry()
                );
    }

    @Override
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
     return    CrudUtill.execute(
                "UPDATE supplier SET name=?,contact_person=?,contact_number=?,email=?,address_1=?,address_2=?,city=?,country=? WHERE id=?",
                supplier.getName(),
                supplier.getContactPerson(),
                supplier.getContactNumber(),
                supplier.getEmail(),
                supplier.getAddress1(),
                supplier.getAddress2(),
                supplier.getCity(),
                supplier.getCountry(),
                supplier.getId()
                );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
      return   CrudUtill.execute("DELETE FROM supplier WHERE id=?",s);
    }

    @Override
    public Supplier findById(String s) throws SQLException, ClassNotFoundException {
     ResultSet set= CrudUtill.execute("SELECT * FROM supplier WHERE id=?",s);
     if (set.next()){
         return new Supplier(
                 set.getString(1),
                 set.getString(2),
                 set.getString(3),
                 set.getString(4),
                 set.getString(5),
                 set.getString(6),
                 set.getString(7),
                 set.getString(8),
                 set.getString(9)
         );
     }
     return null;
    }

    @Override
    public List<Supplier> findAll() throws SQLException, ClassNotFoundException {
        List<Supplier> suppliers = new ArrayList<>();
       ResultSet set= CrudUtill.execute("SELECT * FROM supplier");
       while (set.next()){
           suppliers.add(new Supplier(
                   set.getString(1),
                   set.getString(2),
                   set.getString(3),
                   set.getString(4),
                   set.getString(5),
                   set.getString(6),
                   set.getString(7),
                   set.getString(8),
                   set.getString(9)
           ));
       }
       return suppliers;
    }

    @Override
    public Supplier fetchLastSupplier() throws SQLException, ClassNotFoundException {
     ResultSet set= CrudUtill.execute("SELECT * FROM supplier ORDER BY CAST(SUBSTRING(id,5)AS UNSIGNED)DESC LIMIT 1");
        if (set.next()){
            return new Supplier(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9)
            );
        }
        return null;
    }

    @Override
    public List<Supplier> fetchSuppliersByName(String searchText) throws SQLException, ClassNotFoundException {
        List<Supplier> suppliers = new ArrayList<>();
        ResultSet set = CrudUtill.execute("SELECT * FROM supplier WHERE name LIKE ?", searchText);
        while(set.next()){
            suppliers.add(new Supplier(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9)
            ));
        }
        return suppliers;
    }
}
