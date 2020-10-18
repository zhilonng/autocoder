package com.cj.tools.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TableMapper {

    @Select("select * from information_schema.TABLES where TABLE_SCHEMA=(select database()) AND TABLE_NAME LIKE '%${tableName}%' AND TABLE_COMMENT LIKE '%${tableDesc}%'")
    List<Map> listTable(@Param("tableName")String tableName, @Param("tableDesc")String tableDesc);

    @Select("select * from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
    List<Map> listTableColumn(String tableName);
}
