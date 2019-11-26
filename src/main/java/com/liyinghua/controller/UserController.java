package com.liyinghua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liyinghua.common.CmsAssert;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;
import com.liyinghua.entity.User;
import com.liyinghua.service.ArticleService;
import com.liyinghua.service.ChannelService;
import com.liyinghua.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	private Boolean m=false;
	@Autowired
	private UserService service;
	@Autowired
	private ChannelService service1;
	@Autowired
	private ArticleService service2;
	/**
	 * 
	 * @Title: userLogin 
	 * @Description: 处理用户提交的登录数据
	 * @param hs
	 * @param user
	 * @return
	 * @return: String
	 */

	@SuppressWarnings("unused")
	@RequestMapping("userLogin")
	public String userLogin(HttpServletRequest hs,User user,@RequestParam(defaultValue = "0")Integer n) {
		/**
		 * n判断是否为员工登陆
		 */
		
		if(n==1) {
			
			/**
			 * 用户判断
			 */
			user.setRole(0);
			User userLogin=service.userLogin(user);
			if(userLogin!=null) {
				hs.getSession().setAttribute(ConstantClass.USER_KEY, userLogin);
			/**
			 * j是一个判断用户类型的标签
			 */
				return "redirect:/user/home?j=1";
			}else{
				  hs.setAttribute("user", user);

				  m=true;
				return "redirect:/user/home?j=0"; 		
			}
		}
		/**
		 * 员工
		 */
		user.setRole(1);
		User userLogin=service.userLogin(user);
			if(userLogin!=null) {
				if(userLogin.getRole()==0) {
					hs.setAttribute("mseeage", "非员工用户");
					return "login/login"; 
				}
				hs.getSession().setAttribute(ConstantClass.USER_KEY, userLogin);
				hs.setAttribute("n", true);
				return "redirect:/user/home";
			}else{
				  hs.setAttribute("mseeage", "账户或密码错误");
				  m=true;
				return "login/login"; 		
			}
		  
		
		

	}
	/**
	 * 
	 * @Title: register 
	 * @Description: 注册
	 * @param hs
	 * @param user
	 * @return
	 * @return: String
	 */
	@RequestMapping("register")
	public String  register(HttpServletRequest hs,User user) {
		System.out.println(user.getUsername());
		int result= service.register(user);
		System.out.println(result);
		if(result==0) {
			m=true;
			return "redirect:toRegister/";
		}else {
			hs.getSession().setAttribute(ConstantClass.USER_KEY, user);
		}
		//CmsAssert.AssertTrue(result>0, "用户注册失败,请稍后再试");
		return "redirect:home/";
	}
	
	@RequestMapping("toRegister")
	public String toRegister(HttpServletRequest hs) {
		if(m) {
			hs.setAttribute("message","用户注册失败,请稍后再试");
			m=false;
		}
		return "login/register";
		
	}
	
	@RequestMapping("home")
	public String  toHome(HttpServletRequest hs,User user,@RequestParam(defaultValue = "0")Integer j) {
		List<Article> hotNews=service1.getHotNews();
		List<Channel> list=service1.getChannelList();
		List<Article> imgArticles = service2.getImgArticles(10);
		hs.setAttribute("imgArticles", imgArticles);
		hs.setAttribute("list", list);
		hs.setAttribute("hotNews", hotNews);
		if(m) {
			hs.setAttribute("ErrorMessage", "用户名或密码错误");	
			m=false;
		}else{
			hs.setAttribute("yz",ConstantClass.LOGIN_REGISTER);
			/**
			 * 判断是否为员工,是就个人中心前往管理页面,不是的话,进入个人中心
			 */
			System.out.println(j);
			if(j==1) {
				hs.setAttribute("add",2);
			}else {
				hs.setAttribute("add",1);
			}
			
			/**
			 * 验证是否注册成功或者登录成功
			 */
			hs.setAttribute("mess",1);
		}
		
		
		return "/admin/news/homePage";
	}
	/**
	 * 
	 * @Title: toLogin 
	 * @Description: 前往员工登录
	 * @return
	 * @return: String
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login/login";
		
	}
	/**
	 * 
	 * @Title: getUserNewsList 
	 * @Description: 获取用户所有文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("getUserNewsList")
	public String getUserNewsList(@RequestParam(defaultValue = "1")Integer fy,HttpServletRequest hs) {
		PageInfo<Article> p=service.getUserNewsList(fy);
		hs.setAttribute("p", p);
		return "admin/user/newsList";
	}

	@RequestMapping("exit")
	public String exit(HttpServletRequest hs) {
		List<Article> hotNews=service1.getHotNews();
		List<Channel> list=service1.getChannelList();
		List<Article> imgArticles = service2.getImgArticles(10);
		hs.setAttribute("imgArticles", imgArticles);
		hs.setAttribute("list", list);
		hs.setAttribute("hotNews", hotNews);
		hs.setAttribute("yz", true);
		hs.setAttribute("mess", 0);
		
		HttpSession session = hs.getSession();
		
		session.removeAttribute(ConstantClass.USER_KEY);

		return "/admin/news/homePage";
		
	}
	/**
	 * 
	 * @Title: getUserNewsList 
	 * @Description: 获取本用户所有文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("getUserNewsListByUserId")
	public String getUserNewsListByUserId(@RequestParam(defaultValue = "1")Integer fy,HttpServletRequest hs) {
		User user = (User) hs.getSession().getAttribute(ConstantClass.USER_KEY);
		Integer id = user.getId();
		System.out.println(id);
		PageInfo<Article> p=service.getUserNewsListByUserId(fy,user.getId());
		
		hs.setAttribute("p", p);
		return "admin/user/userNewsList";
	}
	
	@RequestMapping("toLogin1")
	private String toLogin1(){
		return "login/login2";
		
	}
	
	@RequestMapping("postImg")
	private String postImg(HttpServletRequest hs) {
		// 获取所有的频道
				List<Channel> channels =  service1.getChannelList();
				hs.setAttribute("channels",channels);	
				return "admin/news/postimg";
	}
}
