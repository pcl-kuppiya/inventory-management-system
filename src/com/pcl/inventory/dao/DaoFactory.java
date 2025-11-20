package com.pcl.inventory.dao;

import com.pcl.inventory.dao.custom.impl.*;
import com.pcl.inventory.utill.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory=null;
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }
    public <T>T getDao(DaoType daoType){
        switch (daoType){
            case USER: return(T) new UserDaoImpl();
            case CATEGORY:return (T) new CategoryDaoImpl();
            case PRODUCT:return (T) new ProductDaoImpl();
            case SUPPLIER:return (T) new SupplierDaoImpl();
            case CUSTOMER:return (T) new CustomerDaoImpl();
            case CUSTOMERCONTACT:return (T) new CustomerContactDaoImpl();
                default:return null;
        }
    }
}
