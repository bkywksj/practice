package com.my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface QuestionMapper extends BaseMapper<Question> {

    @Insert("insert into question (title,description,tag,gmt_creat,gmt_modified,creator) values (#{title},#{description},#{tag},#{gmtCreat},#{gmtModified},#{creator})")
    Boolean creat(Question question);

    @Select("select * from question")
    List<Question> list();


}
