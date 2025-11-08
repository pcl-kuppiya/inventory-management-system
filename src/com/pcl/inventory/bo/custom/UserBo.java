package com.pcl.inventory.bo.custom;

import com.pcl.inventory.dto.request.RequestUserDto;

import java.sql.SQLException;

public interface UserBo {
  public boolean registerUser(RequestUserDto requestUserDto) throws SQLException, ClassNotFoundException;
}
