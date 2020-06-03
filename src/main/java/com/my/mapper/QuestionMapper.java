package com.my.mapper;



import com.my.entity.Question;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface QuestionMapper {

    @Insert("insert into question (title,description,tag,creator) values (#{title},#{description},#{tag},#{creator})")
    Boolean creat(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(Integer offset,Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{accountId} limit #{offset},#{size}")
    List<Question> listById(String accountId, Integer offset, Integer size);

    @Select("select count(1) from question where creator=#{accountId}")
    Integer countById(String accountId);

    @Select("select * from question where id=#{id}")
    Question findById(Integer id);

    @Update("update question set title=#{title},description=#{description},tag=#{tag} where id =#{id}")
    void update(Question question);

    @Update("update question set view_count=view_count+1 where id=#{id}")
    void updateView(Integer id);
}
