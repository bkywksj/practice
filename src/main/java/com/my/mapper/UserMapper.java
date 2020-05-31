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
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(name,account_id,bio,token,gmt_creat,gmt_modified,avatar_url) values (#{name},#{accountId},#{bio},#{token},#{gmtCreat},#{gmtModified},#{avatarUrl})")
    int insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(String token);

    @Select("select * from user where account_id = #{creator} limit 1")
    User findByAccountId(String creator);
}
