package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "accountService")
public class AccountService
{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	public List<PageData> findlistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("AccountMapper.findlistPage", page);
	}
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("AccountMapper.findById", pd);
	}
	
	public void updateById(PageData pd) throws Exception
	{
		dao.findForObject("AccountMapper.updateById", pd);
	}
	
	public void save(PageData pd) throws Exception
	{
		dao.findForObject("AccountMapper.save", pd);
	}
	
	public void removeAll(int[] ids) throws Exception
	{
		dao.findForObject("AccountMapper.removeAll", ids);
	}

	public List<PageData> findAllLogin(PageData pd) throws Exception
	{
		return (List<PageData>) dao.findForList("DataEntryMapper.findAllLogin", pd);
	}
}
