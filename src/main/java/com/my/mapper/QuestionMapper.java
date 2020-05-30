package com.my.mapper;

import com.my.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMapper {

    @Insert("insert into question (title,description,tag,gmt_creat,gmt_modified,creator) values (#{title},#{description},#{tag},#{gmtCreat},#{gmtModified},#{creator})")
    Boolean creat(Question question);
}
