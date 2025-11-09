package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.ProductBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.ProductDao;
import com.pcl.inventory.dto.response.ResponseCategoryDto;
import com.pcl.inventory.entity.Category;
import com.pcl.inventory.entity.Product;
import com.pcl.inventory.utill.DaoType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo {
    ProductDao productDao= DaoFactory.getInstance().getDao(DaoType.PRODUCT);
    @Override
    public String getLastProductID() throws SQLException, ClassNotFoundException {
        Product lastProduct = productDao.getLastProduct();
        if(lastProduct != null){
            String lastProdIdAsString = lastProduct.getId();
            String[] split = lastProdIdAsString.split("-");
            int lastDigit = Integer.parseInt(split[1]);
            lastDigit++;
            return  "PROD-"+lastDigit;


        }
        return "PROD-1";
    }

    @Override
    public List<ResponseCategoryDto> getAllCategories() throws SQLException, ClassNotFoundException {
        List<Category> allCategories = productDao.getAllCategories();
        List<ResponseCategoryDto> catList = new ArrayList<>();
        for (Category cat:allCategories){
            catList.add(new ResponseCategoryDto(
                    cat.getId(),
                    cat.getName(),
                    cat.getDescription()
            ));

        }

        return catList;
    }
}
