package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface EmployeeService
{

	public void updateEmpById(PageData pd) throws Exception;
	
	public void save(PageData pd) throws Exception;
	
	public List<PageData> datalistPage(Page page) throws Exception;

	public List<PageData> findAlllistPage(Page page) throws Exception;

	public PageData findById(PageData pd) throws Exception;
	
	public void deleteById(PageData pd) throws Exception;
	
	public void updateWEPayTimeById(PageData pd) throws Exception;
}
