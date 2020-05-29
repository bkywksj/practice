package com.my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*
 *
 *@author Ye
 *@create 2020/5/29 18:15
 */
@Repository
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_creat,gmt_modified) values (#{name},#{account_id},#{token},#{gmtCreat},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(String token);
}
