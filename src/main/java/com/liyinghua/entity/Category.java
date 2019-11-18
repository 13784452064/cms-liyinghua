package com.liyinghua.entity;

import java.io.Serializable;
/**
 * 
 * @ClassName: Category 
 * @Description: 每个频道对应的分类表
 * @author:李英华
 * @date: 2019年11月14日 下午6:32:02
 */
public class Category implements Serializable {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 7337149315767865706L;
	/**
	 * 类型id
	 */
	private Integer id           ;
	/**
	 * 类型名称
	 */
	private String name         ;
	/**
	 * 对应的频道id
	 */
	private Integer channelId   ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Category(Integer id, String name, Integer channelId) {
		super();
		this.id = id;
		this.name = name;
		this.channelId = channelId;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channelId=" + channelId + "]";
	}
	

}
