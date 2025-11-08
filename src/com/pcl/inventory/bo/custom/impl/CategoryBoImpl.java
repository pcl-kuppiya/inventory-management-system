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

    @Override
    public String getCategoryId() throws SQLException, ClassNotFoundException {
        Category lastCategory = categoryDao.fetchLastCategory();
        if (lastCategory != null) {
            String lastCategoryId = lastCategory.getId();
            String[] splittedId = lastCategoryId.split("-");
            String lastCharacterAsString = splittedId[1];
            int lastDigit = Integer.parseInt(lastCharacterAsString);
            lastDigit++;
            return  "CAT-" + lastDigit;
        }
            return "CAT-1";

    }
}
