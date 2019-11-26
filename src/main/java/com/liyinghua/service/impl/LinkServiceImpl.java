package com.liyinghua.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.dao.LinkMapper;
import com.liyinghua.entity.Link;
import com.liyinghua.service.LinkService;
@Service
public class LinkServiceImpl implements LinkService {
	
	@Autowired
	LinkMapper mapper;
	@Override
	public Integer add(Link link) {
		// TODO Auto-generated method stub
		return mapper.add(link);
	}
	@Override
	public PageInfo<Link> list(int fy) {
		// TODO Auto-generated method stub
		PageHelper.startPage(fy, ConstantClass.PAGE_SIZE);
		PageInfo<Link> p=new PageInfo<Link>(mapper.list());
		return p;
	}
	@Override
	public Integer delLink(Integer linkId) {
		// TODO Auto-generated method stub
		return mapper.delLink(linkId);
	}
	@Override
	public Link getLinkById(Integer linkId) {
		// TODO Auto-generated method stub
		return mapper.getLinkById(linkId);
	}
	@Override
	public Integer update(Link link) {
		// TODO Auto-generated method stub
		return mapper.update(link);
	}

}
