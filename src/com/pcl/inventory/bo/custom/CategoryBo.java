package com.pcl.inventory.bo.custom;

import com.pcl.inventory.dto.request.RequestCategoryDto;
import com.pcl.inventory.dto.response.ResponseCategoryDto;

import java.sql.SQLException;
import java.util.List;

public interface CategoryBo {
    public boolean saveCategory(RequestCategoryDto categoryDto) throws SQLException, ClassNotFoundException;
    public String getCategoryId() throws SQLException, ClassNotFoundException;
    public List<ResponseCategoryDto> getCategoryByName(String searchText) throws SQLException, ClassNotFoundException;
    public boolean updateCategory(RequestCategoryDto categoryDto) throws SQLException, ClassNotFoundException;

}
