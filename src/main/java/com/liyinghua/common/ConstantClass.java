package com.liyinghua.common;
/**
 * 
 * @ClassName: ConstantClass 
 * @Description: 保存cms系统常量
 * @author:李英华
 * @date: 2019年11月13日 下午1:12:13
 */
public class ConstantClass {
	/**
	 * 普通用户
	 */
	public static  final Integer DOMESITC_CONSUMER=0;
	/**
	 * 管理员
	 */
	public static  final Integer ADMINISTRATOR=1;
	/**
	 * 每页数据条数
	 */
	public static  final Integer PAGE_SIZE=5;
	/**
	 * 状态符合解禁要求
	 */
	public static  final Integer ACCORD=0;
	/**
	 * 状态不符合解禁要求
	 */
	public static  final Integer INCONFORMITY=1;
	/**
	 * 用于登录获取session
	 */
	public static final String USER_KEY="SESSION_USER_KEY";
	/**
	 * 登录注册验证
	 */
	public static  final Boolean LOGIN_REGISTER=false;
}
