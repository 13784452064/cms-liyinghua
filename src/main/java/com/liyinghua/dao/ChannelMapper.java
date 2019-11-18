package com.liyinghua.dao;

import java.util.List;

import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;

public interface ChannelMapper {
	/**
	 * 
	 * @Title: getChannelList 
	 * @Description: 获取频道列表
	 * @return
	 * @return: List<Channel>
	 */
	public List<Channel> getChannelList();
	/**
	 * 
	 * @Title: findById 
	 * @Description: 新闻的xml中,resultMap要用到
	 * @param id
	 * @return
	 * @return: List<Channel>
	 */
	public List<Channel> findById(Integer id);
	/**
	 * 
	 * @Title: getHotNews 
	 * @Description: 获取热门文章
	 * @return
	 * @return: List<Article>
	 */
	public List<Article> getHotNews();
	
	

}
