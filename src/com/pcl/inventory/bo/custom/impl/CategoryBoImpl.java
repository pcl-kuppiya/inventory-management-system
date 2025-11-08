package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.CategoryBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.CategoryDao;
import com.pcl.inventory.dto.request.RequestCategoryDto;
import com.pcl.inventory.dto.response.ResponseCategoryDto;
import com.pcl.inventory.entity.Category;
import com.pcl.inventory.utill.DaoType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ResponseCategoryDto> getCategoryByName(String searchText) throws SQLException, ClassNotFoundException {
        List<ResponseCategoryDto> responseCategoryDtos = new ArrayList<>();
        String name="%"+searchText+"%";
        List<Category> categoryByName = categoryDao.findCategoryByName(name);
        for (Category category:categoryByName) {
            responseCategoryDtos.add(new ResponseCategoryDto(
                    category.getId(),
                    category.getName(),
                    category.getDescription()
            ));

        }
        return responseCategoryDtos;

    }
}
