package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface ChargeStandardService
{
	public PageData findById(PageData pd) throws Exception;
	
	public void updateById(PageData pd) throws Exception;
	
	public List<PageData> findAll(Page page) throws Exception;
}
