package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.SupplierBo;
import com.pcl.inventory.dto.request.RequestSupplierDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;

import java.util.List;

public class SupplierBoImpl implements SupplierBo {
    @Override
    public boolean create(RequestSupplierDto dto) {
        return false;
    }

    @Override
    public boolean update(RequestSupplierDto dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ResponseSupplierDto findById(String id) {
        return null;
    }

    @Override
    public List<ResponseSupplierDto> findAll() {
        return List.of();
    }
}
