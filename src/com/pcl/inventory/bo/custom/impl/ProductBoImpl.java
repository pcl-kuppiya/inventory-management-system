package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.ProductBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.ProductDao;
import com.pcl.inventory.entity.Product;
import com.pcl.inventory.utill.DaoType;

import java.sql.SQLException;

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
}
