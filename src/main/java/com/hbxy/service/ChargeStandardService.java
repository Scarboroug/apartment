package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface ChargeStandardService
{
	PageData findById(PageData pd) throws Exception;
	
	void updateById(PageData pd) throws Exception;
	
	List<PageData> findAll(Page page) throws Exception;
}
