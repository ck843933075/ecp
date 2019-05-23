package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Img;
import com.zhiyou100.pojo.ProjectType;
import com.zhiyou100.pojo.Region;

public interface ProductService {

//	int addPic(Img img);

	int addPics(Img img);

	List<Region> findAllProvince();

	List<Region> findAllCities(Integer id);

	List<ProjectType> findAllProjectType();

	
}
