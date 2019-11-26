package com.liyinghua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Collect;
import com.liyinghua.service.CollectService;

@Controller
@RequestMapping("collect")
public class CollectController {
	@Autowired
	private CollectService service;
	
	@ResponseBody
	@RequestMapping("addCollect")
	private Object addCollect(Collect col) {
		Integer addCollectid=service.addCollect(col);
		if(addCollectid>0) {
			return true;
		}else {
			return false;
		}
	}
	
	@RequestMapping("getUserCollect")
	public String getUserCollectByUserId(Integer id,@RequestParam(defaultValue = "1")Integer fy,HttpServletRequest hs) {
		PageInfo<Collect> p=service.getUserCollectByUserId(id,fy);
		List<Collect> list = p.getList();
		hs.setAttribute("p", p);
		return "admin/news/collectList";
		
	}
	@ResponseBody
	@RequestMapping("del")
	public Object del(Integer id) {
		Integer n=service.del(id);
		return n;
		
	}
}
