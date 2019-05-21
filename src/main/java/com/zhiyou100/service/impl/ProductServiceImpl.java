package com.zhiyou100.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.ProductMapper;
import com.zhiyou100.pojo.Img;
import com.zhiyou100.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper productMapper;
	
	/*@Override
	public int addPic(Img img) {
		return productMapper.addPic(img);
	}
*/
	@Override
	public int addPics(Img img) {
		
		return productMapper.addPics(img);
	}

}
