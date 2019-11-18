package com.liyinghua.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Article;
import com.liyinghua.service.ArticleService;

@Controller
@RequestMapping("home/Article")
public class ArticleController {
	private Integer chanId=0;
	@Autowired()
	private ArticleService service;
	/**
	 * 
	 * @Title: getArticleByChannelId 
	 * @Description: 通过频道id获取新闻列表
	 * @param channelId
	 * @param hs
	 * @param fy
	 * @return
	 * @return: String
	 */
	@RequestMapping("getArticleBychannelId")
	private String getArticleByChannelId(Integer channelId,HttpServletRequest hs,@RequestParam(defaultValue ="1")Integer fy) {
		/**
		 * 频道的id共享
		 */
		chanId=0;
		if(chanId==0) {
			chanId=channelId;
			System.out.println(chanId);
		}

		List<Article> list= service.getArticleByChannelId(channelId,fy);
		hs.setAttribute("Articles", list);
		return "admin/news/categoryNews";
	}
	/**
	 * 
	 * @Title: getArticleBychannelIdAndByCategoryId 
	 * @Description: 通过频道ID和分类id共同获得符合条件的新闻列表
	 * @param categoryId
	 * @param hs
	 * @param fy
	 * @return
	 * @return: String
	 */
	@RequestMapping("getArticleBychannelIdAndByCategoryId")
	private String getArticleBychannelIdAndByCategoryId(Integer categoryId,HttpServletRequest hs,@RequestParam(defaultValue ="1")Integer fy) {
		List<Article> list= service.getArticleBychannelIdAndByCategoryId(categoryId,fy,chanId);
		hs.setAttribute("Articles", list);
		return "admin/news/categoryNews";
	}
	/**
	 * 
	 * @Title: getContent 
	 * @Description: 获取文章内容
	 * @param articleId
	 * @return
	 * @return: String
	 */
	@RequestMapping("getContent")
	private String getgetContentContent(Integer articleId,HttpServletRequest hs) {
		Article list=service.getArticleById(articleId);
		hs.setAttribute("content",list);
		return "admin/news/news";
		
	}
}
