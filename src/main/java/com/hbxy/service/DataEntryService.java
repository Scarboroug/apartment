package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface DataEntryService
{
	void save(PageData pd) throws Exception;
	
	void updateById(PageData pd) throws Exception;
	
	PageData findById(PageData pd) throws Exception;
	
	List<PageData> listPage(Page page) throws Exception;
	
	List<PageData> updateDaysById(PageData pd) throws Exception;
	
}
