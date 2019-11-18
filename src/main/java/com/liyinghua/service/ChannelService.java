package com.liyinghua.service;

import java.util.List;

import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;

public interface ChannelService {
	/**
	 * 
	 * @Title: getChannelList 
	 * @Description: 获取频道列表
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> getChannelList();
	/**
	 * 
	 * @Title: getHotNews 
	 * @Description: 获取热门视频
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getHotNews();

}
