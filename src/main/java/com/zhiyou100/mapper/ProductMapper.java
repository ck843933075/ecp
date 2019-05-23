package com.zhiyou100.mapper;

import java.util.List;

import com.zhiyou100.pojo.Img;
import com.zhiyou100.pojo.ProjectType;
import com.zhiyou100.pojo.Region;

public interface ProductMapper {

	int addPics(Img img);

	List<Region> findAllProvince();

	List<Region> findAllCities(Integer id);

	List<ProjectType> findAllProjectType();

//	int addPic(Img img);

}
