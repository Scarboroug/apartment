package com.hbxy.dao;

import org.apache.ibatis.annotations.Param;

import com.hbxy.bean.LoginBean;

public interface LoginDao {

	/**
	 * 根据登录名查询用户信息
	 * @param loginName
	 * @return LoginBean用户
	 */
	LoginBean findByLoginName(@Param("loginName") String loginName);
	
	/**
	 * 插入用户信息
	 * @param login
	 */
	void insertLogin(LoginBean login);
	
	/**
	 * 根据用户名修改密码
	 * @param loginName
	 * @param password
	 */
	void updatePasswordByLoginName(@Param("loginName") String loginName, @Param("password") String password);
	
	/**
	 * 根据用户名删除用户
	 * @param loginName
	 */
	void deleteByLoginName(@Param("loginName") String loginName);

}
