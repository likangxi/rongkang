package com.goods.lkx.controller;
import com.goods.lkx.entity.User;
import com.goods.lkx.mapper.UserMapper;
import com.goods.lkx.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lkx")
public class UserController {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    //查询接口
   @GetMapping("/allUser")
    public List<User> getUser(){
        return userMapper.findAll();
    }
    @PostMapping()
    public Integer save(User user){
        System.out.println(user);
     return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public  Integer shanchu(@PathVariable Integer id){
       System.out.println(id);
       return userMapper.delete(id);
    }
//@RequestParam接收pageNum=1&pageSize
    @GetMapping("/page")
    public Map<String ,Object> findpage(@RequestParam Integer pageNum ,@RequestParam Integer pageSize){
       pageNum=(pageNum-1)*pageSize;
       List<User> data =userMapper.selectPage(pageNum,pageSize);
       Integer total =userMapper.selectTotal();
        Map<String ,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
         return res;
    }
}