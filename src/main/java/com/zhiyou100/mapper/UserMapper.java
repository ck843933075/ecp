package com.zhiyou100.mapper;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	int checkMailPhone(String mailOrPhone);

	String checkCodeTime(String mailOrPhone);

	int addCode(@Param("mailCode")String mailCode, @Param("mailOrPhone")String mailOrPhone);

	int checkCode(@Param("code") String code ,@Param("mailOrPhone") String mailOrPhone);

	int login(@Param("username")String username, @Param("password") String password);

}
