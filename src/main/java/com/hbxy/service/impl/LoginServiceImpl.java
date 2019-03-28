package com.hbxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hbxy.bean.LoginBean;
import com.hbxy.dao.LoginDao;
import com.hbxy.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService
{
	@Resource
	private LoginDao loginDao;
	
	@Override
	public LoginBean findByLoginName(String loginName)
	{
		return loginDao.findByLoginName(loginName);
	}

	@Override
	public void insertLogin(LoginBean login)
	{
		loginDao.insertLogin(login);
	}

	@Override
	public void updatePasswordByLoginName(String loginName, String password)
	{
		loginDao.updatePasswordByLoginName(loginName, password);
	}

	@Override
	public void deleteByLoginName(String loginName)
	{
		loginDao.deleteByLoginName(loginName);
	}
	
}
