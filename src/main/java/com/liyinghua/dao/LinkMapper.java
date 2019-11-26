package com.liyinghua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.liyinghua.entity.Link;
/**
 * 
 * @ClassName: LinkMapper 
 * @Description: 友情链接
 * @author:李英华
 * @date: 2019年11月23日 上午8:28:14
 */
public interface LinkMapper {
	
	
	public int add(Link link);

	public List<Link> list();

	public Integer delLink(@Param("linkId")Integer linkId);

	public Link getLinkById(@Param("linkId")Integer linkId);

	public Integer update(Link link);

}
