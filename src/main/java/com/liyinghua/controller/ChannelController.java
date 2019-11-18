package com.liyinghua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;
import com.liyinghua.service.ChannelService;

@Controller
@RequestMapping("home")
public class ChannelController {
	@Autowired
	private ChannelService service;
	/**
	 * 
	 * @Title: toHomePage 
	 * @Description: 获取热门新闻和频道列表 传入首页
	 * @param hs
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"toHomePage","/"})
	private String toHomePage(HttpServletRequest hs) {
		List<Article> hotNews=service.getHotNews();
		List<Channel> list=service.getChannelList();
		hs.setAttribute("list", list);
		hs.setAttribute("hotNews", hotNews);
		return "admin/news/homePage";
	}
}
