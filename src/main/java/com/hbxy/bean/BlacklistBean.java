package com.hbxy.bean;

public class BlacklistBean extends BaseBean
{
	private Integer blacklistId;
	private String blacklistName;
	private String blacklistIdNumber;
	private Double debt;
	
	public BlacklistBean(){}
	
	public BlacklistBean(String blacklistName,
			String blacklistIdNumber, Double debt)
	{
		this.blacklistName = blacklistName;
		this.blacklistIdNumber = blacklistIdNumber;
		this.debt = debt;
	}

	public Integer getBlacklistId()
	{
		return blacklistId;
	}

	public void setBlacklistId(Integer blacklistId)
	{
		this.blacklistId = blacklistId;
	}

	public String getBlacklistName()
	{
		return blacklistName;
	}

	public void setBlacklistName(String blacklistName)
	{
		this.blacklistName = blacklistName;
	}

	public String getBlacklistIdNumber()
	{
		return blacklistIdNumber;
	}

	public void setBlacklistIdNumber(String blacklistIdNumber)
	{
		this.blacklistIdNumber = blacklistIdNumber;
	}

	public Double getDebt()
	{
		return debt;
	}

	public void setDebt(Double debt)
	{
		this.debt = debt;
	}
}
