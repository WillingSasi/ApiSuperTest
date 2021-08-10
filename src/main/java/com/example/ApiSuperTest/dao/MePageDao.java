package com.example.ApiSuperTest.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface MePageDao {
    //获取下载链接
    @Select("select x from xx where xxx")
    List<String> getDownloadUrlList();
}
