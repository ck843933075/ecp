package com.zhiyou100.util;

// 数据工具类
public class ResultUtil {
	private int code ; //设置状态码 返回0 表示成功， 1表示失败
	private String msg ; //设置返回说明 
	private Object data ; //设置返回的数据
	
	
	
	public ResultUtil(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}


	public ResultUtil(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}


	//返回成功数据的方法 ,不带内容和数据
	public static ResultUtil success(){
		return new ResultUtil(0, "", null);
	}
	
	//返回成功数据的方法 ,带内容和数据
	public static ResultUtil success(String msg , Object object){
		return new ResultUtil(0, msg, object);
	}
	
	//返回不成功数据的方法 ,带内容
		public static ResultUtil error(String msg ){
			return new ResultUtil(1, msg);
		}
		
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
