package com.zsl.homestay.service;

import com.github.pagehelper.PageInfo;
import com.zsl.homestay.model.User;
import com.zsl.homestay.model.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    public PageInfo<User> queryAllUser(User user);

    public boolean login(String userName, String password);

    public Integer updateUser(User user);

    public User selectById(String id);

    public Integer create(UserDTO user);

    public Integer deleteById(String id);
}
