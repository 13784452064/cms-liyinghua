package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.liyinghua.dao.CategoryMapper;
import com.liyinghua.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper mapper;
	/**
	 * 通过频道获取分类
	 */
	@Override
	public List getCategoryByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		
		return mapper.getCategoryByChannelId(channelId);
	}

}
