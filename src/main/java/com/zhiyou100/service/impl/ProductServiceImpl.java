package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.ProductMapper;
import com.zhiyou100.pojo.Img;
import com.zhiyou100.pojo.ProjectType;
import com.zhiyou100.pojo.Region;
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

	@Override
	public List<Region> findAllProvince() {
		List<Region> list = productMapper.findAllProvince();
		return list;
	}

	@Override
	public List<Region> findAllCities(Integer id) {
		
		return productMapper.findAllCities(id);
	}

	@Override
	public List<ProjectType> findAllProjectType() {
		
		return productMapper.findAllProjectType();
	}

}
