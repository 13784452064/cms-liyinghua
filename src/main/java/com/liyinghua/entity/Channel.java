package com.liyinghua.entity;

import java.io.Serializable;

public class Channel implements Serializable{   
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 4139238131654061870L;
	/**
	 * 频道ID
	 */
	private Integer id            ;
	/**
	 * 频道名
	 */
	private String name          ;
	private String description   ;
	private String icon          ;
	public Channel(Integer id, String name, String description, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
	}
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + "]";
	}
	

}
