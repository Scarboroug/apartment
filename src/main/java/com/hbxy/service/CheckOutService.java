package com.hbxy.service;

import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("checkOutService")
public class CheckOutService
{
	@Resource(name = "daoSupport")
	DaoSupport dao;
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("CheckOutMapper.findById", pd);
	}
	
	public PageData findByRoomTypeId(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("CheckOutMapper.findByRoomTypeId", pd);
	}
}
