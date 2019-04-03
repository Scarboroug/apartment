package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEntryService
{
	@Autowired
	DaoSupport dao;
	
	public void save(PageData pd) throws Exception
	{
		dao.save("DataEntryMapper.save", pd);
	}
	
	public void updateById(PageData pd) throws Exception
	{
		dao.update("DataEntryMapper.updateById", pd);
	}
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("DataEntryMapper.findById", pd);
	}
	
	public List<PageData> listPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("DataEntryMapper.listPage", page);
	}
	
	public List<PageData> updateDaysById(PageData pd) throws Exception
	{
		return (List<PageData>) dao.findForList("DataEntryMapper.updateDaysById", pd);
	}
	
}
