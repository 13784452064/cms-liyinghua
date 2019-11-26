package com.liyinghua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.liyinghua.entity.Article;
import com.liyinghua.entity.User;

public interface UserMapper {
	/**
	 * 
	 * @Title: getUsersList 
	 * @Description: 查询用户列表
	 * @param mohu
	 * @return
	 * @return: List<User>
	 */
	public List<User> getUsersList(@Param("mohu")String mohu);
	/**
	 * 
	 * @Title: getUserById 
	 * @Description: 通过id查找用户
	 * @param id
	 * @return
	 * @return: List<User>
	 */
	public List<User> getUserById(@Param("id")Integer id);
	/**
	 * 
	 * @Title: updLocked 
	 * @Description: 修改用户状态
	 * @param id
	 * @param locked
	 * @return
	 * @return: Integer
	 */
	@Update("update cms_user set locked=${locked} where id=${id}")
	public Integer updLocked(@Param("id")Integer id,@Param("locked") Integer locked);
	/**
	 * 
	 * @Title: findByName 
	 * @Description: 查找用户是否存在
	 * @param username
	 * @param role 
	 * @return
	 * @return: User
	 */
	public User findByName(@Param("username")String username, @Param("role")Integer role);
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加用户
	 * @param user
	 * @return
	 * @return: int
	 */
	public int add(User user);


}
