package com.goods.lkx.mapper;

import com.goods.lkx.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM sys_user")
    List<User>findAll();
    @Insert("INSERT into sys_user (id,username,password,nickname,email,phone,address)VALUES(null,#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);
    int update(User user);
    @Delete("DELETE FROM sys_user WHERE id=#{id}")
    Integer delete(@Param("id") Integer id);
    @Select("select *from sys_user limit #{pageNum},#{pageSize}")
    List<User> selectPage (Integer pageNum,Integer pageSize);
    @Select("SELECT COUNT(*)  FROM sys_user")
    Integer selectTotal();
}
