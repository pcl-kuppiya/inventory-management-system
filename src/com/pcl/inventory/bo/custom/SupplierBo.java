package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;
import com.pcl.inventory.dto.request.RequestSupplierDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBo extends SuperBo {
    public boolean create(RequestSupplierDto dto) throws SQLException, ClassNotFoundException;
    public boolean update(RequestSupplierDto dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public ResponseSupplierDto findById(String id) throws SQLException, ClassNotFoundException;
    public List<ResponseSupplierDto> findAll() throws SQLException, ClassNotFoundException;
    public String getSupplierId() throws SQLException, ClassNotFoundException;
    public List<ResponseSupplierDto> getSuppliersByName(String text) throws SQLException, ClassNotFoundException;


}
