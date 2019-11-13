package com.liyinghua.entity;

import java.io.Serializable;
import java.util.Date;

import com.liyinghua.common.ConstantClass;

public class User implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 8061014508355330869L;
	/*
	 * 用户编号
	 */
	private Integer id            ;
	/*
	 * 用户名
	 */
	private String username      ;
	/*
	 * 用户密码
	 */
	private String password      ;
	/*
	 * 昵称
	 */
	private String nickname      ;
	/*
	 * 生日
	 */
	private String birthday      ;
	/*
	 * 性别
	 */
	private Integer gender        ;
	/*
	 * 是否被禁
	 */
	private Integer locked        ;
	/*
	 * 注册时间
	 */
	private Date createTime   ;
	private Date updateTime   ;
	private String url           ;
	private String score         ;
	/**
	 * 身份
	 */
	private Integer role =ConstantClass.DOMESITC_CONSUMER ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	


}
