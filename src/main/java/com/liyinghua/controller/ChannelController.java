package com.liyinghua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;
import com.liyinghua.service.ArticleService;
import com.liyinghua.service.ChannelService;

@Controller
@RequestMapping(value = {"/"})
public class ChannelController {
	@Autowired
	private ChannelService service;
	@Autowired
	private ArticleService service2;
	/**
	 * 
	 * @Title: toHomePage 
	 * @Description: 获取热门新闻和频道列表 传入首页
	 * @param hs
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"toHomePage","/"})
	private String toHomePage(HttpServletRequest hs,@RequestParam(defaultValue = "0")int n) {
		List<Article> hotNews=service.getHotNews();
		List<Channel> list=service.getChannelList();
		List<Article> imgArticles = service2.getImgArticles(10);
		hs.setAttribute("imgArticles", imgArticles);
		hs.setAttribute("list", list);
		hs.setAttribute("hotNews", hotNews);
		hs.setAttribute("yz", true);
		if(n==1) {
			
		}
		return "admin/news/homePage";
	}
	
	@RequestMapping("login")
	private String to(HttpServletRequest hs) {

		return "/login/login";
	}
}
