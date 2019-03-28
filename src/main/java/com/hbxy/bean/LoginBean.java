package com.hbxy.bean;

public class LoginBean extends BaseBean
{
	private Integer loginId;
	private String loginName;
	private String password;
	private Integer role;

	public LoginBean(){}

	public LoginBean(String loginName, String password, Integer role)
	{
		this.loginName = loginName;
		this.password = password;
		this.role = role;
	}

	public LoginBean(Integer loginId, String loginName, String password,
			Integer role)
	{
		this.loginId = loginId;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
	}

	public Integer getLoginId()
	{
		return loginId;
	}

	public void setLoginId(Integer loginId)
	{
		this.loginId = loginId;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}
}
