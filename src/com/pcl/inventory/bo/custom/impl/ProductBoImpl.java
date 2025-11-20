package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.ProductBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.CategoryDao;
import com.pcl.inventory.dao.custom.ProductDao;
import com.pcl.inventory.dao.custom.SupplierDao;
import com.pcl.inventory.dto.request.RequestProductDto;
import com.pcl.inventory.dto.response.ResponseCategoryDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;
import com.pcl.inventory.entity.Category;
import com.pcl.inventory.entity.Product;
import com.pcl.inventory.entity.Supplier;
import com.pcl.inventory.utill.DaoType;
import com.pcl.inventory.utill.tools.IdSplitter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo {
    ProductDao productDao= DaoFactory.getInstance().getDao(DaoType.PRODUCT);
    CategoryDao categoryDao= DaoFactory.getInstance().getDao(DaoType.CATEGORY);
    SupplierDao supplierDao= DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
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
        List<Category> allCategories = categoryDao.findAll();
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

    @Override
    public List<String> getAllSuppliers() throws SQLException, ClassNotFoundException {
        List<Supplier> all = supplierDao.findAll();
        List<String> supList = new ArrayList<>();
        for (Supplier sup:all){
            supList.add(sup.getId()+"-"+sup.getName());
        }
        return supList;

    }

    @Override
    public boolean createProduct(RequestProductDto productDto) throws SQLException, ClassNotFoundException {
      return   productDao.save(new Product(
           productDto.getId(),
           productDto.getName(),
           productDto.getUnitPrice(),
           productDto.getStock(),
           productDto.getDescription(),
           IdSplitter.splitId(productDto.getCategory()),
           productDto.getUser(),
          IdSplitter.splitId( productDto.getSupplier())
        ));
    }


    @Override
    public boolean updateProduct(RequestProductDto productDto) throws SQLException, ClassNotFoundException {
        return   productDao.update(new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getUnitPrice(),
                productDto.getStock(),
                productDto.getDescription(),
                IdSplitter.splitId(productDto.getCategory()),
                productDto.getUser(),
                IdSplitter.splitId( productDto.getSupplier())
        ));
    }
}
