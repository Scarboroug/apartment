package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeStandardService
{
	@Autowired
	private DaoSupport dao;
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("ChargeStandardMapper.findById", pd);
	}
	
	public void updateById(PageData pd) throws Exception
	{
		dao.update("ChargeStandardMapper.update", pd);
	}
	
	public List<PageData> findAll(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("ChargeStandardMapper.findAlllistPage", page);
	}
}
