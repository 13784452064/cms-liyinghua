package com.liyinghua.common;
/**
 * 
 * @ClassName: StatusMessages 
 * @Description: 用户状态信息(是否禁用)
 * @author:李英华
 * @date: 2019年11月13日 下午7:40:12
 */
public class StatusMessages {
	/**
	 * 信息编号
	 */
	private Integer wrongNumber;
	/**
	 * 提示信息
	 */
	private String hint;
	/**
	 * 
	 */
	private Object date;
	public Integer getWrongNumber() {
		return wrongNumber;
	}
	public void setWrongNumber(Integer wrongNumber) {
		this.wrongNumber = wrongNumber;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}
	public StatusMessages(Integer wrongNumber, String hint, Object date) {
		super();
		this.wrongNumber = wrongNumber;
		this.hint = hint;
		this.date = date;
	}
	public StatusMessages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
