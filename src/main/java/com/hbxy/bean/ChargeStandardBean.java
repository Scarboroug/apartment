package com.hbxy.bean;

public class ChargeStandardBean extends BaseBean {

	private Integer csId;
	private String csName;
	private Double csPrice;
	private String csUnit;
	
	public ChargeStandardBean(){}
	
	public ChargeStandardBean(String csName, Double csPrice, String csUnit)
	{
		this.csName = csName;
		this.csPrice = csPrice;
		this.csUnit = csUnit;
	}

	public ChargeStandardBean(Integer csId, String csName, Double csPrice,
			String csUnit)
	{
		this.csId = csId;
		this.csName = csName;
		this.csPrice = csPrice;
		this.csUnit = csUnit;
	}

	public Integer getCsId()
	{
		return csId;
	}

	public void setCsId(Integer csId)
	{
		this.csId = csId;
	}

	public String getCsName()
	{
		return csName;
	}

	public void setCsName(String csName)
	{
		this.csName = csName;
	}

	public Double getCsPrice()
	{
		return csPrice;
	}

	public void setCsPrice(Double csPrice)
	{
		this.csPrice = csPrice;
	}

	public String getCsUnit()
	{
		return csUnit;
	}

	public void setCsUnit(String csUnit)
	{
		this.csUnit = csUnit;
	}

}
