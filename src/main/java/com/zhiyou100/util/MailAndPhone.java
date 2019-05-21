package com.zhiyou100.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import net.sf.json.JSONObject;

public class MailAndPhone {
	
	 public static final String DEF_CHATSET = "UTF-8";
	    public static final int DEF_CONN_TIMEOUT = 30000;
	    public static final int DEF_READ_TIMEOUT = 30000;
	    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	 
	    //配置您申请的KEY
	    public static final String APPKEY ="1c05d2c15d57a16298ad7ae77380fcd9";

	public static String getMailCode(String MailAdd ){
		//		获取邮箱验证码
		//		获取session对象  第一个参数中设置的两个参数内容：第一个是服务器的主机名 第二个参数就是是否需要验证用户
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");

		//		第二个参数设置认证器，即校验客户端身份，需要自己实现Authenticator接口，实现这个接口需要使用到账户和密码
		Authenticator authenticator = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("18539658381@163.com", "caokai5214008");
			}

		};

		Session session = Session.getDefaultInstance(props, authenticator);

		//		第二步创建MimeMessage
		MimeMessage message = new MimeMessage(session);
		//		设置收件人地址、发件人地址、主题、正文
		try {
			message.setFrom(new InternetAddress("18539658381@163.com"));
			message.addRecipients(RecipientType.TO, MailAdd);
			message.setSubject("测试邮件！");
			/*UUID uuid = UUID.randomUUID();
			String code = uuid.toString().substring(0,6);*/
			Date date = new Date();
			long time = date.getTime();
			String code = (""+time).substring((""+time).length()-6, (""+time).length());
			System.out.println("code :" + code);
			message.setContent("您的验证码是"+code +"打死都不要告诉别人", "text/plain;charset=utf-8");
			//发送邮件
			Transport.send(message);

			return code;


		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null ;

	}

	//获取手机验证码
	public static String getPhoneCode(String phone ){
		String result =null;
		String url ="http://v.juhe.cn/sms/send";//请求接口地址
		Map params = new  HashMap();//请求参数
		params.put("mobile",phone);//接收短信的手机号码
		params.put("tpl_id","157972");//短信模板ID，请参考个人中心短信模板设置

		UUID uuid = UUID.randomUUID();
		String code = uuid.toString().substring(0, 6);
		System.out.println(code);

		params.put("tpl_value","#code#="+ code);//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
		params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
		params.put("dtype","json");//返回数据的格式,xml或json，默认json

		try {
			result =net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if(object.getInt("error_code")==0){
				System.out.println(object.get("result"));
			}else{
				System.out.println(object.get("error_code")+":"+object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return code;
	}

	public static String net(String strUrl, Map params,String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if(method==null || method.equals("GET")){
				strUrl = strUrl+"?"+urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if(method==null || method.equals("GET")){
				conn.setRequestMethod("GET");
			}else{
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params!= null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}
	//将map型转为请求参数型
	public static String urlencode(Map<String,Object>data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
