package com.hbxy.bean;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseBean {

	//页
	private Integer page;
	//页大小
	private Integer pageSize;
	//起始下标
	private Integer fromIndex;
	
	public Integer getFromIndex()
	{
		return fromIndex;
	}

	public void setFromIndex(Integer fromIndex)
	{
		this.fromIndex = fromIndex;
	}

	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
