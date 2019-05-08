package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface AccountService {

	List<PageData> findlistPage(Page page) throws Exception;
	
	PageData findById(PageData pd) throws Exception;
	
	void updateById(PageData pd) throws Exception;
	
	void save(PageData pd) throws Exception;
	
	void removeAll(int[] ids) throws Exception;

	List<PageData> findAllLogin(PageData pd) throws Exception;

}
