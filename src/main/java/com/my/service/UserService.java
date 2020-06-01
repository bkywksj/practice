package com.my.service;

import com.my.entity.User;
import com.my.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *
 *@author Ye
 *@create 2020/6/1 12:50
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void creatOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser == null) {
            userMapper.insert(user);
        }else{

            userMapper.update( user);
        }
    }
}
