package com.zhiyou100.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片工具类
 * @author Administrator
 * @date 2019年5月16日
 * @version
 */
public class ImageUtil {
	/**
	 * 上传图片
	 * @param request 请求
	 * @param file 图片文件
	 * @return
	 * String	生成的新的图片地址
	 */
	public static String upload(HttpServletRequest request , MultipartFile file){
		String imgPath = null ;
		
//		上传图片
		if(file != null || !file.isEmpty()){
//			使用UUID进行重命名，将UUID中的 - 取消掉 
			String name = UUID.randomUUID().toString().replaceAll("-", "");
//			获取上传图片的后缀名
			String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
//			设置图片的上传路径
			String realpath = request.getSession().getServletContext().getRealPath("/uploads");
//			检查当前文件是否存在
			if(!isFolder(realpath)){
				return null; 
			}
//			以绝对路径保存重命名的图片
			try {
//				realPath : F:/a/uploads / xxxxxxxx   . jpg
				file.transferTo(new File(realpath + "/" + name + "." + suffix));
				//返回图片在项目中的相对路径
				return "uploads/" + name + "." + suffix ;				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return null ;
	}
	
	/**
	 * 校验当前目录是否存在  不存在就直接创建
	 * @param path
	 * @return
	 * boolean
	 */
	public static boolean isFolder(String path){
		File file = new File(path);
		if(!file.exists()){
			if (file.mkdir()) {
				return true;
			}else{
				return false ;
			}
		}else{
			System.out.println("路径：" + path);
			return true ;
		}
		
	}
}
