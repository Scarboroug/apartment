package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface DataEntryService
{
	public void save(PageData pd) throws Exception;
	
	public void updateById(PageData pd) throws Exception;
	
	public PageData findById(PageData pd) throws Exception;
	
	public List<PageData> listPage(Page page) throws Exception;
	
	public List<PageData> updateDaysById(PageData pd) throws Exception;
	
}
