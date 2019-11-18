package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyinghua.dao.ChannelMapper;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;

import com.liyinghua.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelMapper mapper;
	/**
	 * 获取频道列表
	 */
	@Override
	public List<Channel> getChannelList() {
		// TODO Auto-generated method stub
		return mapper.getChannelList();
	}
	/**
	 * 获取热门新闻列表
	 */
	@Override
	public List<Article> getHotNews() {
		// TODO Auto-generated method stub
		return mapper.getHotNews();
	}
	
}
