package com.zhiyou100.service;

import java.util.Map;

import com.zhiyou100.util.ResultUtil;

public interface UserService {

	ResultUtil checkMailPhone(String  mailOrPhone);

	ResultUtil checkCode(String code, String mailOrPhone);

	int addCode(String s,String mailCode);

	int login(String username, String password);


}
