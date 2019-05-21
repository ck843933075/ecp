package com.zhiyou100.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.ResultUtil;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	@Override
	public ResultUtil checkMailPhone(String  mailOrPhone) {
		int num = userMapper.checkMailPhone(mailOrPhone);
		System.out.println("num:" +num);
		if(num == 0 ){
			return ResultUtil.success("ok", null);
		}else{
			return ResultUtil.error("not ok");
		}
		
	}

	@Override
	public ResultUtil checkCode(String code, String mailOrPhone) {
		//判断是否过期
		String dateString = userMapper.checkCodeTime(mailOrPhone);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date);
		System.out.println("date:" +date.getTime());
		System.out.println("system:" + new Date().getTime());
		if(new Date().getTime() - date.getTime() > 10*60*1000){
			return ResultUtil.error("验证码过期");
		}else{
			int num = userMapper.checkCode(code , mailOrPhone);
			if(num == 1){
				return ResultUtil.success("可以注册",null);
			}else{
				return ResultUtil.error("验证码错误");
			}
		}
		
	}

	@Override
	public int addCode(String mailOrPhone, String mailCode) {
		
		return userMapper.addCode(mailCode,mailOrPhone);
	}

	@Override
	public int login(String username, String password) {
		int num = userMapper.login( username, password);
		return num ;
	}

	

}
