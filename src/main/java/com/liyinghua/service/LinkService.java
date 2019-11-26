package com.liyinghua.service;



import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Link;

public interface LinkService {

	public Integer add(Link link);
	
	public PageInfo<Link> list(int fy);

	public Integer delLink(Integer linkId);

	public Link getLinkById(Integer linkId);

	public Integer update(Link link);

}
