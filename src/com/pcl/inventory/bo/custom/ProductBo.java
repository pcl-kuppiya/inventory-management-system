package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;
import com.pcl.inventory.dto.response.ResponseCategoryDto;

import java.sql.SQLException;
import java.util.List;

public interface ProductBo extends SuperBo {
    public String getLastProductID() throws SQLException, ClassNotFoundException;
    public List<ResponseCategoryDto> getAllCategories() throws SQLException, ClassNotFoundException;
}
