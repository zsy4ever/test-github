package com.zsl.homestay.mapper;

import com.zsl.homestay.model.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    public List<User> queryAll(User user);

    public Integer deleteById(String id);

    public Integer updateUser(User user);

    public User selectById(String id);

    public Integer create(User user);

    public User selectUserName(@Param("userName") String userName);

    public String selectPassword(@Param("password") String password);

}
