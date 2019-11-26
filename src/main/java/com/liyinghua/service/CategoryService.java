package com.liyinghua.service;

import java.util.List;

import com.liyinghua.entity.Category;



public interface CategoryService {
	/**
	 * 
	 * @Title: getCategoryByChannelId 
	 * @Description: 通过频道获得分类
	 * @param channelId
	 * @return
	 * @return: List
	 */
	List<Category> getCategoryByChannelId(Integer channelId);

}
