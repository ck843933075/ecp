package com.zhiyou100.controll;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.service.UserService;
import com.zhiyou100.util.MailAndPhone;
import com.zhiyou100.util.ResultUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService ;
	
	@RequestMapping("/register1")
	@ResponseBody
	public String register(String mailOrPhone){
		//进行数据校验
		if(mailOrPhone.contains("@")){
			String mailCode = MailAndPhone.getMailCode(mailOrPhone);
			int num = userService.addCode(mailOrPhone,mailCode);
			return  ""+num;
		}else{
			String phoneCode = MailAndPhone.getPhoneCode(mailOrPhone);
			return phoneCode;
		}
	}
	
//	验证邮箱和手机号是否被注册
	@RequestMapping("/checkMailPhone")
	@ResponseBody
	public ResultUtil checkMailPhone( String mailOrPhone){
		return userService.checkMailPhone(mailOrPhone);
	}
	
//	判断验证码是否失效
	@RequestMapping("/checkCode")
	@ResponseBody
	public ResultUtil checkCode(String code ,String mailOrPhone){
		//该验证码是否过期
		//判断该验证码是否相等
		return userService.checkCode(code , mailOrPhone);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultUtil login(String username , String password ,String save_pwd, HttpServletRequest request , HttpServletResponse response){
//		save_pwd  yes no
		
		System.out.println(save_pwd);
		
		System.out.println("username : " + username );
		System.out.println("password : " + password);
		int num = userService.login(username , password);
		System.out.println("num:" + num);
		if(num == 1){
			request.getSession().setAttribute("user", username);
			if(save_pwd.equals("yes")){
				Cookie cookie1 = new Cookie("username", username);
				cookie1.setMaxAge(1000*60*60);
				Cookie cookie2 = new Cookie("password", password);
				cookie2.setMaxAge(1000*60*60);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
			return ResultUtil.success();
		}else {
			return ResultUtil.error("no user");
		}
	}
	
	
	
}
