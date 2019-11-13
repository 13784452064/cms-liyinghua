package com.liyinghua.service;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.User;

public interface UserService {
	/**
	 * 
	 * @Title: getUsersList 
	 * @Description: 用户列表
	 * @param fy
	 * @param mohu
	 * @return
	 * @return: PageInfo<User>
	 */
	PageInfo<User> getUsersList(Integer fy, String mohu);
	/**
	 * 
	 * @Title: getUserById 
	 * @Description: 通过id查找用户
	 * @param id
	 * @return
	 * @return: Boolean
	 */
	Boolean getUserById(Integer id);
	/**
	 * 
	 * @Title: updLocked 
	 * @Description: 修改用户状态
	 * @param id
	 * @param locked
	 * @return
	 * @return: Integer
	 */
	Integer updLocked(Integer id, Integer locked);

}
