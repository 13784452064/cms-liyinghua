package com.liyinghua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
	/**
	 * 
	 * @Title: getCategoryByChannelId 
	 * @Description: 通过频道id 获取 频道中的分类列表
	 * @param channelId
	 * @return
	 * @return: List
	 */
	List getCategoryByChannelId(@Param("channelId")Integer channelId);
	/**
	 * 
	 * @Title: findById 
	 * @Description: 新闻的xml中,resultMap要用到
	 * @param id
	 * @return
	 * @return: List
	 */
	List findById(Integer id);


}
