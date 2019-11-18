package com.liyinghua.service;

import java.util.List;



public interface CategoryService {
	/**
	 * 
	 * @Title: getCategoryByChannelId 
	 * @Description: 通过频道获得分类
	 * @param channelId
	 * @return
	 * @return: List
	 */
	List getCategoryByChannelId(Integer channelId);

}
