package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;
import com.pcl.inventory.dto.request.RequestSupplierDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;

import java.util.List;

public interface SupplierBo extends SuperBo {
    public boolean create(RequestSupplierDto dto);
    public boolean update(RequestSupplierDto dto);
    public boolean delete(String id);
    public ResponseSupplierDto findById(String id);
    public List<ResponseSupplierDto> findAll();


}
