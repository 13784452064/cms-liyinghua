package com.liyinghua.service;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Article;
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
	
	/**
	 * 
	 * @Title: userLogin 
	 * @Description: 用户登录
	 * @param user
	 * @return
	 * @return: User
	 */
	User userLogin(User user);
	/**
	 * 
	 * @Title: register 
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int register(User user);
	/**
	 * 
	 * @Title: getUserNewsList 
	 * @Description: 获取用户所有的新闻(分页)
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> getUserNewsList(Integer fy);
	/**
	 * 
	 * @Title: getUserNewsList 
	 * @Description: 获取本用户所有的新闻(分页)
	 * @param fy
	 * @param id
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> getUserNewsListByUserId(Integer fy, Integer id);

}
