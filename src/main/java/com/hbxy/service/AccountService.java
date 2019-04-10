package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface AccountService
{

	public List<PageData> findlistPage(Page page) throws Exception;
	
	public PageData findById(PageData pd) throws Exception;
	
	public void updateById(PageData pd) throws Exception;
	
	public void save(PageData pd) throws Exception;
	
	public void removeAll(int[] ids) throws Exception;

	public List<PageData> findAllLogin(PageData pd) throws Exception;
}
