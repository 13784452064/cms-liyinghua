package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.dao.UserMapper;
import com.liyinghua.entity.User;
import com.liyinghua.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	/**
	 * 用户列表展示的功能(包括分页和模糊)
	 */
	@Override
	public PageInfo<User> getUsersList(Integer fy, String mohu) {
		PageHelper.startPage(fy,ConstantClass.PAGE_SIZE);
		System.out.println(mohu);
		List<User> list=mapper.getUsersList(mohu);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}
	/**
	 * 通过id查找用户
	 */
	@Override
	public Boolean getUserById(Integer id) {
		// TODO Auto-generated method stub
		List<User> userById = mapper.getUserById(id);
		return userById.size()==0;
	}
	/**
	 * 修改用户状态
	 */
	@Override
	public Integer updLocked(Integer id, Integer locked) {
		// TODO Auto-generated method stub
		if(locked==1) {
			
			return mapper.updLocked(id,0);
		}else {
			return mapper.updLocked(id,1);
		}
		
	}

}
