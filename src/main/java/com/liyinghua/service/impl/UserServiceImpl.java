package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyinghua.common.CmsAssert;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.common.Md5;
import com.liyinghua.dao.ArticleMapper;
import com.liyinghua.dao.UserMapper;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.User;
import com.liyinghua.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	@Autowired
	private  ArticleMapper mapper1;
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
	/**
	 * 判断是否存在用户
	 * @param integer 
	 */
	public User findByName(String username, Integer role) {
		return mapper.findByName(username,role);
		
	}
	/**
	 * 用户登录
	 */
	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getRole()+"-------------------******");
		User userLogin=findByName(user.getUsername(),user.getRole());
		if(userLogin==null) {
			return null;
		}
		//计算加盐加密后的密码
		String pwdSaltMd5=Md5.password(user.getPassword(), user.getUsername().substring(0, 2));
		//与数据库去对比
		if(pwdSaltMd5.equals(userLogin.getPassword())) {
			return userLogin;
		}else {
			return null;
		}
	}
	/**
	 * 注册
	 */
	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		//用户名是否存在
		User existUser = findByName(user.getUsername(),null);
		//CmsAssert.AssertTrue(existUser==null, "该用户名已经存在");
		
		//加盐
		System.out.println(existUser!=null);
		if(existUser!=null) {
			return 0;
		}else {
			user.setPassword(Md5.password(user.getPassword(),
			user.getUsername().substring(0, 2)));
			return mapper.add(user);
		}
		
	}
	/**
	 * 获取所有用户文章
	 */
	@Override
	public PageInfo<Article> getUserNewsList(Integer fy) {
		// TODO Auto-generated method stub
		PageHelper.startPage(fy, ConstantClass.PAGE_SIZE);
		List<Article> list=mapper1.getUserNewsList();
		PageInfo<Article> p= new PageInfo<Article>(list);
		return p;
	}
	@Override
	public PageInfo<Article> getUserNewsListByUserId(Integer fy, Integer id) {
		// TODO Auto-generated method stub
		PageHelper.startPage(fy, ConstantClass.PAGE_SIZE);
		List<Article> list=mapper1.getUserNewsListByUserId(id);
		PageInfo<Article> p= new PageInfo<Article>(list);
		return p;
	}

}
