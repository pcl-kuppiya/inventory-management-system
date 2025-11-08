package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.CategoryBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.CategoryDao;
import com.pcl.inventory.dto.request.RequestCategoryDto;
import com.pcl.inventory.entity.Category;
import com.pcl.inventory.utill.DaoType;

import java.sql.SQLException;

public class CategoryBoImpl implements CategoryBo {
    CategoryDao categoryDao= DaoFactory.getInstance().getDao(DaoType.CATEGORY);
    @Override
    public boolean saveCategory(RequestCategoryDto categoryDto) throws SQLException, ClassNotFoundException {
     return  categoryDao.save(
              new Category(
                      categoryDto.getId(),
                      categoryDto.getName(),
                      categoryDto.getDescription()
              )
        );
    }
}
