package com.spring.cloud.springbootdemo.mapper;

import com.spring.cloud.springbootdemo.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface InfoMapper {

    @Select("select * from info where id=#{id}")
    Info findById(@Param("id") Integer id);
}
