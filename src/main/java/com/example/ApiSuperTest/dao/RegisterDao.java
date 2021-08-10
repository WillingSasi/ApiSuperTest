package com.example.ApiSuperTest.dao;

import com.example.ApiSuperTest.dto.LoginInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface RegisterDao {

    @Select("select x from xx where xxx = #{personId}")
    LoginInfoDTO selectByPersonId(@Param("personId") String personId);

    @Select("select x from xx where xxx = #{personId} and xxxx = #{phoneNumber}")
    LoginInfoDTO selectByPersonIdAndPhoneNumber(@Param("personId") String personId, @Param("phoneNumber") String phoneNumber);
}
