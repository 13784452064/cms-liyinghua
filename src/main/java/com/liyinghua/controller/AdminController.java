package com.liyinghua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liyinghua.common.StatusMessages;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;
import com.liyinghua.entity.Link;
import com.liyinghua.entity.User;
import com.liyinghua.service.ArticleService;
import com.liyinghua.service.ChannelService;
import com.liyinghua.service.UserService;


@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private UserService service;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService service2;
	
	/**
	 * +
	 * @Title: index 
	 * @Description: 跳转中心页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("hello")
	public String index(Model m) {
		return "admin/index";
		
	}
	/**
	 * 
	 * @Title: getUsersList 
	 * @Description: 获取用户列表(包括分页和模糊查询)
	 * @param hr
	 * @param mohu
	 * @param fy
	 * @return
	 * @return: String
	 */
	@RequestMapping("userlist")
	private String getUsersList(HttpServletRequest hs ,String mohu,@RequestParam(defaultValue = "1")Integer fy) {		
		  System.out.println(mohu);
		  PageInfo<User> info=service.getUsersList(fy,mohu);
		  hs.setAttribute("info",info);
		  hs.setAttribute("mohu", mohu);
		return "admin/user/userlist";
	}
	/**
	 * 
	 * @Title: updLocked 
	 * @Description: 修改用户状态 (首先要进行用户是否存在查询,其次再判断传过来的状态值是否符合要求)
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@RequestMapping("updLocked")
	private Object updLocked(Integer id,Integer locked) {
		
		Boolean n=service.getUserById(id);
		if(n) {
			return new StatusMessages(1, "信息有误,请刷新", null);
		}
		System.out.println(locked);
		if(locked==1||locked==0) {
			
		}else {
			return new StatusMessages(2, "状态有误,请联系管理员", null);
		}
		if(service.updLocked(id,locked)>0) {
			return new StatusMessages(0, "修改成功", null);
		}
		return  new StatusMessages(3, "修改失败,请联系管理员", null);
		
	}
	/**
	 * 
	 * @Title: toHomePage 
	 * @Description: 跳转首页(传入频道列表)
	 * @param hs
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"/toHomePage","/"})
	private String toHomePage(HttpServletRequest hs) {
		
		List<Article> hotNews=channelService.getHotNews();
		List<Channel> list=channelService.getChannelList();
		List<Article> imgArticles = service2.getImgArticles(10);
		hs.setAttribute("imgArticles", imgArticles);
		hs.setAttribute("list", list);
		hs.setAttribute("hotNews", hotNews);
		hs.setAttribute("yz", true);
		hs.setAttribute("yz", true);
		return "admin/news/homePage";
		
	}
	
	@RequestMapping("UserHello")
	private String UserHello() {
		return "admin/userIndex";
		
	}
	
}
