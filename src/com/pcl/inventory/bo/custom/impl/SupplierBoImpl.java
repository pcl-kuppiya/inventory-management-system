package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.SupplierBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.SupplierDao;
import com.pcl.inventory.dto.request.RequestSupplierDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;
import com.pcl.inventory.entity.Supplier;
import com.pcl.inventory.utill.DaoType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBoImpl implements SupplierBo {
    SupplierDao supplierDao = DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
    @Override
    public boolean create(RequestSupplierDto dto) throws SQLException, ClassNotFoundException {
     return    supplierDao.save(new Supplier(
                dto.getId(),
                dto.getName(),
                dto.getContactPerson(),
                dto.getContactNumber(),
                dto.getEmail(),
                dto.getAddress1(),
                dto.getAddress2(),
                dto.getCity(),
                dto.getCountry()
        ));
    }

    @Override
    public boolean update(RequestSupplierDto dto) throws SQLException, ClassNotFoundException {
        return  supplierDao.update(
               new Supplier(
                       dto.getId(),
                       dto.getName(),
                       dto.getContactPerson(),
                       dto.getContactNumber(),
                       dto.getEmail(),
                       dto.getAddress1(),
                       dto.getAddress2(),
                       dto.getCity(),
                       dto.getCountry()
               )
       );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
      return supplierDao.delete(id);
    }

    @Override
    public ResponseSupplierDto findById(String id) throws SQLException, ClassNotFoundException {
        Supplier selectedSupplier = supplierDao.findById(id);
        return  new ResponseSupplierDto(
                selectedSupplier.getId(),
                selectedSupplier.getName(),
                selectedSupplier.getContactPerson(),
                selectedSupplier.getContactNumber(),
                selectedSupplier.getEmail(),
                selectedSupplier.getAddress1(),
                selectedSupplier.getAddress2(),
                selectedSupplier.getCity(),
                selectedSupplier.getCountry()
        );
    }

    @Override
    public List<ResponseSupplierDto> findAll() throws SQLException, ClassNotFoundException {
        List<Supplier> supplierList = supplierDao.findAll();
        List<ResponseSupplierDto> responseSupplierDtoList = new ArrayList<>();
        for (Supplier sup:supplierList){
            responseSupplierDtoList.add(new ResponseSupplierDto(
                sup.getId(),
                sup.getName(),
                sup.getContactPerson(),
                sup.getContactNumber(),
                sup.getEmail(),
                sup.getAddress1(),
                sup.getAddress2(),
                sup.getCity(),
                sup.getCountry()
            ));
        }
        return responseSupplierDtoList;
    }
}
