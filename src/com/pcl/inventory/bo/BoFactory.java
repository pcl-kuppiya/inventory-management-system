package com.pcl.inventory.bo;

import com.pcl.inventory.bo.custom.UserBo;
import com.pcl.inventory.bo.custom.impl.CategoryBoImpl;
import com.pcl.inventory.bo.custom.impl.UserBoImpl;
import com.pcl.inventory.utill.BoType;

public class BoFactory {
        private static BoFactory boFactory;
        private BoFactory() {}

    public static BoFactory getInstance() {
            if (boFactory == null) {
                boFactory = new BoFactory();
            }
            return boFactory;
    }

    public <T>T getBoFactory(BoType boType) {
            switch (boType) {
                case USER: return (T) new UserBoImpl();
                case CATEGORY:return (T) new CategoryBoImpl();
                default:return  null;
            }
    }
}
