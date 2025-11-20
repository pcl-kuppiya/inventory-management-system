package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;
import com.pcl.inventory.dto.request.RequestProductDto;
import com.pcl.inventory.dto.response.ResponseCategoryDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;
import com.pcl.inventory.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductBo extends SuperBo {
    public String getLastProductID() throws SQLException, ClassNotFoundException;
    public List<ResponseCategoryDto> getAllCategories() throws SQLException, ClassNotFoundException;
    public List<String> getAllSuppliers() throws SQLException, ClassNotFoundException;
    public boolean createProduct(RequestProductDto productDto) throws SQLException, ClassNotFoundException;
    public boolean updateProduct(RequestProductDto productDto) throws SQLException, ClassNotFoundException;

}
