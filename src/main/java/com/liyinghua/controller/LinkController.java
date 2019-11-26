package com.liyinghua.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Link;
import com.liyinghua.service.LinkService;

@Controller
@RequestMapping("link")
public class LinkController {
	@Autowired
	private LinkService service;
	@RequestMapping("toLink")
	public String toList(Model m,@RequestParam(defaultValue = "1")Integer fy) {
		Link link = new Link();
		m.addAttribute("link",link);
		PageInfo<Link> p = service.list(fy);		
		m.addAttribute("LinkInfo", p);
		return "admin/link/list";
	}
	@RequestMapping("addLink")
	public String Add(@Valid @ModelAttribute("link")Link link,BindingResult result,HttpServletRequest hs,@RequestParam(defaultValue = "1")Integer fy) {
		if(result.hasErrors()) {
			PageInfo<Link> p = service.list(fy);
			hs.setAttribute("LinkInfo", p);
			return "admin/link/list";
		}
		Integer addMessage=service.add(link);
		PageInfo<Link> p = service.list(fy);
		hs.setAttribute("LinkInfo", p);
		return "admin/link/list";	
	}
	@RequestMapping("linkList")
	public String linkList(@RequestParam(defaultValue = "1")Integer fy,HttpServletRequest hs) {
		PageInfo<Link> p = service.list(fy);
		hs.setAttribute("link", new Link());
		hs.setAttribute("LinkInfo", p);
		return "admin/link/list";	
	}
	@RequestMapping("delLink")
	public String delLink(Integer linkId,HttpServletRequest hs,@RequestParam(defaultValue = "1")Integer fy) {
		Integer del=service.delLink(linkId);
		System.out.println(del);
		PageInfo<Link> p = service.list(fy);
		hs.setAttribute("LinkInfo", p);
		Link link = new Link();
		hs.setAttribute("link",link);
		return "admin/link/list";
		
	}
	@RequestMapping("toUpdate")
	public String toUpdate(Integer linkId,HttpServletRequest hs,@RequestParam(defaultValue = "1")Integer fy) {
		Link link=service.getLinkById(linkId);
		hs.setAttribute("link",link);
		PageInfo<Link> p = service.list(fy);
		hs.setAttribute("LinkInfo", p);
		return "admin/link/update";
		
	}
	@RequestMapping("update")
	public String update(Link link,HttpServletRequest hs,@RequestParam(defaultValue = "1")Integer fy) {
		Integer updId=service.update(link);
		PageInfo<Link> p = service.list(fy);
		hs.setAttribute("LinkInfo", p);
		return "admin/link/list";
	}
}
