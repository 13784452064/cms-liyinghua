package com.liyinghua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyinghua.entity.Category;
import com.liyinghua.service.CategoryService;

@Controller
@RequestMapping("/home/Category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	/**
	 * 
	 * @Title: getCategoryByChannelId 
	 * @Description: 通过频道id获取所属的分类
	 * @param channelId
	 * @param hs
	 * @return
	 * @return: String
	 */
	@RequestMapping("getCategoryByChannelId")
	public String  getCategoryByChannelId(Integer channelId,HttpServletRequest hs) {

		List<Category> Categorys=service.getCategoryByChannelId(channelId);
		hs.setAttribute("Categorys", Categorys);
		return "admin/category/categorys";
	}

	/**
	 * 
	 * @Title: getCategoryByChannelId 
	 * @Description: 通过频道id获取所属的分类
	 * @param channelId
	 * @param hs
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("getCategoryByChannel")
	public Object  getCategoryByChannel(Integer channelId,HttpServletRequest hs) {

		List<Category> Categorys=service.getCategoryByChannelId(channelId);

		return Categorys;
	}
}
