package com.pcl.inventory.bo.custom.impl;

import com.pcl.inventory.bo.custom.UserBo;
import com.pcl.inventory.dao.DaoFactory;
import com.pcl.inventory.dao.custom.UserDao;
import com.pcl.inventory.dao.custom.impl.UserDaoImpl;
import com.pcl.inventory.db.DbConnection;
import com.pcl.inventory.dto.request.RequestUserDto;
import com.pcl.inventory.dto.response.ResponseUserDto;
import com.pcl.inventory.entity.User;
import com.pcl.inventory.utill.DaoType;
import com.pcl.inventory.utill.security.PasswordManager;

import java.sql.SQLException;
import java.util.UUID;

public class UserBoImpl implements UserBo {
    private UserDao userDao=DaoFactory.getInstance().getDao(DaoType.USER);


    @Override
    public boolean registerUser(RequestUserDto requestUserDto) throws SQLException, ClassNotFoundException {
       return userDao.save(new User(
                UUID.randomUUID().toString(),
                requestUserDto.getEmail(),
                requestUserDto.getDisplayName(),
                requestUserDto.getContactNumber(),
                new PasswordManager().encode(requestUserDto.getPassword())
        ));
            }

    @Override
    public ResponseUserDto login(String email, String password) throws SQLException, ClassNotFoundException {
        User user = userDao.findByEmail(email);
        if (user!=null){
            if (new PasswordManager().check(password,user.getPassword())){
                return new ResponseUserDto(
                 user.getEmail(),
                        user.getDisplayName(),
                       "200" ,
                        "Authentication success",
                        user.getId()
                );
            }
            return new ResponseUserDto(
                    user.getEmail(),
                    null,
                    "401",
                    "Password incorrect",
                    null
            );
        }
        return null;
    }
}

