package com.github.xrapalexandra.kr.dao;

import com.github.xrapalexandra.kr.model.User;
import com.github.xrapalexandra.kr.model.UserAddress;

public interface UserDao {

    Integer addUser(User user);

    User getByLogin(String login);

    Boolean delUser(Integer userId);

    void updatePass(User user);

    void updateAddress(User user);

    Integer addAddress(User user);

    UserAddress getUserAddress(Integer userId);
}
