package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.dao.CollectMapper;
import com.liyinghua.entity.Collect;
import com.liyinghua.service.CollectService;

@Service
/** 
 * @ClassName: CollectServiceImpl 
 * @Description: TODO
 * @author:李英华
 * @date: 2019年11月23日 下午3:46:41  
 */
public class CollectServiceImpl implements CollectService{
	
	@Autowired
	private CollectMapper mapper;
	@Override
	public Integer addCollect(Collect col) {
		// TODO Auto-generated method stub
		return mapper.addCollect(col);
	}
	@Override
	public PageInfo<Collect> getUserCollectByUserId(Integer userId,Integer fy) {
		System.out.println(fy);
		PageHelper.startPage(fy, ConstantClass.PAGE_SIZE);
		List<Collect> list=mapper.getUserCollectByUserId(userId);
		PageInfo<Collect> p=new PageInfo<Collect>(list);
		return p;
	}
	@Override
	public Integer del(Integer id) {
		// TODO Auto-generated method stub
		return mapper.del(id);
	}
	
}
