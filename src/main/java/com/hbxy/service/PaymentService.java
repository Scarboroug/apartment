package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("paymentService")
public class PaymentService
{
	@Resource(name = "daoSupport")
	DaoSupport dao;

	public List<PageData> listPage(PageData pd) throws Exception
	{
		return (List<PageData>) dao.findForList("PaymentMapper.listPage", pd);
	}
	
	public List<PageData> listPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("PaymentMapper.listPage", page);
	}
	
	public List<PageData> findEmpByRoomId(PageData pd) throws Exception
	{
		return (List<PageData>) dao.findForList("PaymentMapper.findEmpByRoomId", pd);
	}
	
	public List<PageData> findRentlistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("PaymentMapper.findRentlistPage", page);
	}
	
	
}
