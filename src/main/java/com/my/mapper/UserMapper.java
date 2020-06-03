package com.my.mapper;


import com.my.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/*
 *
 *@author Ye
 *@create 2020/5/29 18:15
 */
@Repository
public interface UserMapper {

    @Insert("insert into user(name,account_id,bio,token,avatar_url) values (#{name},#{accountId},#{bio},#{token},#{avatarUrl})")
    int insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(String token);

    @Select("select * from user where account_id = #{creator} limit 1")
    User findByAccountId(String creator);

    @Update("update user set name=#{name},bio=#{bio},token=#{token},avatar_url=#{avatarUrl} where account_id=#{accountId}")
    void update(User user);
}
