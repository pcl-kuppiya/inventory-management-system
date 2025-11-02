package com.pcl.inventory.dao.custom;

import com.pcl.inventory.dao.CrudDao;
import com.pcl.inventory.entity.User;

import java.util.List;

public interface UserDao extends CrudDao<User,String> {
    public List findByName(String name);
}
