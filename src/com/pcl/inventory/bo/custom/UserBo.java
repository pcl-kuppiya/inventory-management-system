package com.pcl.inventory.bo.custom;

import com.pcl.inventory.bo.SuperBo;
import com.pcl.inventory.dto.request.RequestUserDto;
import com.pcl.inventory.dto.response.ResponseUserDto;

import java.sql.SQLException;

public interface UserBo extends SuperBo {
  public boolean registerUser(RequestUserDto requestUserDto) throws SQLException, ClassNotFoundException;
  public ResponseUserDto login(String email, String password) throws SQLException, ClassNotFoundException;
}
