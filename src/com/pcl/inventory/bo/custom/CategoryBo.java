package com.pcl.inventory.bo.custom;

import com.pcl.inventory.dto.request.RequestCategoryDto;

import java.sql.SQLException;

public interface CategoryBo {
    public boolean saveCategory(RequestCategoryDto categoryDto) throws SQLException, ClassNotFoundException;
}
