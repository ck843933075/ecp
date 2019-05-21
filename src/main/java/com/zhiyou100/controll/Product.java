package com.zhiyou100.controll;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zhiyou100.pojo.Img;
import com.zhiyou100.service.ProductService;
import com.zhiyou100.util.ImageUtil;

@Controller
public class Product {
	@Autowired
	ProductService productService; 

	/*@RequestMapping("/addPic")
	public String addPic(@RequestParam("file") CommonsMultipartFile file ,HttpServletRequest request){
		Img img = new Img();
		String username = request.getParameter("username");
		img.setUsername(username);

		System.out.println("file : " + file);
//		使用图片工具类获取到图片的新名称
		String imgPath = ImageUtil.upload(request, file);
//		判断图片返回值
		if(imgPath != null){
//			将图片地址封装到实体类中
			img.setImg(imgPath);
			request.setAttribute("imgPath", imgPath);
		}
		int num = productService.addPic(img);
		if(num == 1 ){
			return "pages/a.jsp?msg=ok";
		}
		return "pages/a.jsp?msg=error";
	}*/

	//	多文件上传
	@RequestMapping("/addPics")
	public String addPics(@RequestParam("file") CommonsMultipartFile [] files ,HttpServletRequest request){
		Img img = new Img();
		String username = request.getParameter("username");
		img.setUsername(username);
		List<String> list  = new ArrayList<>();
		
		for(CommonsMultipartFile file : files){
			String imgPath = ImageUtil.upload(request, file);
			//			判断图片返回值
			if(imgPath != null){
				//			将图片地址放到集合中
				list.add(imgPath);
			}
		}
		//		将图片地址封装到实体类中
		img.setImg(list);
		int num = productService.addPics(img);
		request.getSession().setAttribute("img", img);
		
		if(num == 1 ){
			return "pages/a.jsp?msg=ok";
		}
		return "pages/a.jsp?msg=error";
	}

	@RequestMapping("/down")
	public void down(HttpServletRequest request , HttpServletResponse response) throws Exception{
//		获取到资源文件路径
		String fileName = request.getSession().getServletContext().getRealPath("uploads")+"/08784a064a594c749a45e57c977db01c.jpg";
		System.out.println(fileName);
//		获取输入流
		InputStream in = new BufferedInputStream(new FileInputStream(new File(fileName)));
		//设置一个文件名
		String name = "a.jpg";
//		设置文件下载响应头 ，表示下载的资源
		response.setHeader("Content-Disposition", "attachment:filename="+fileName);
//		设置文件的响应类型 表示当前响应的为文件
		response.setContentType("multipart/form-data");
//		设置输出流
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
//		接收文件
		int len = 0 ;
		while((len = in.read()) != -1){
			out.write(len);
			out.flush();
		}
		out.close();
	
	}
	
}



//	@RequestMapping("/file1")
//	public ModelAndView addPic( MultipartFile file , HttpServletRequest request ,HttpServletResponse response) throws Exception{
//		System.out.println(request.getParameter("username"));
//	
//		InputStream inputStream = file.getInputStream();
//		
//		
//////		创建工厂
////		DiskFileItemFactory	dFactory = new DiskFileItemFactory();
//////		使用工厂创建资源解析器
////		ServletFileUpload	fileUpload = new ServletFileUpload(dFactory);
//////		使用解析器加载request中的参数，获取到FileItem对象集合
////		List<FileItem> list =  fileUpload.parseRequest(request);
//////		遍历所有的表单项
////		for(FileItem fileItem : list ){
//////			判断当前表单项是否属于普通字段,true普通字段 false文件字段
////			if( fileItem.isFormField()){
//////				获取当前字段名称
////				String fieldName = fileItem.getFieldName();
//////				获取当前字段值
////				String fieldValue = fileItem.getString();
////			System.out.println(fieldName + " = " + fieldValue);
////			}else{//进入判断文件字段
//////				获取当前文件字段的文件名
////				String name = fileItem.getName();
//////				如果文件名称为空，说明没有上传文件
////				if(name == null || name.isEmpty()){
////					continue ;
////				}
//////				获取真实路径，将该文件真实保存的地址 应用名/uploads文件夹下，此目录必须先行创建
////				String path = request.getSession().getServletContext().getRealPath("/uploads");
////				System.out.println("path:" + path);
//////				通过uploads目录和文件名进行创建File对象
////				File file = new File(path);
//////				把上面的文件保存到固定位置
////				fileItem.write(file);
////				System.out.println("上传文件：" + name);
////				System.out.println("文件大小：" + fileItem.getSize());
////				System.out.println("上传文件类型：" + fileItem.getContentType());
////				
////			}
////		}
//		
////		ModelAndView mv = new ModelAndView();
////		
////		mv.setViewName("pages/a.jsp");
////		return mv ;
//		
//	}

