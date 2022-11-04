package com.goods.lkx.service;

import com.goods.lkx.entity.User;
import com.goods.lkx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;;
    //通过判断id是否存在来进行新增或者修改
    public int save( @RequestBody User user){
        if (user.getId()==null){
            System.out.println("新增成功");
            userMapper.insert(user);
            return userMapper.insert(user);
        }else {
            System.out.println("修改成功");
            userMapper.update(user);
            return userMapper.update(user);
        }
    }
}