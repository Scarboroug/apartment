package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.PaymentService;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService
{
	@Autowired
	private DaoSupport dao;

	@Override
	public List<PageData> listPage(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("PaymentMapper.listPage", pd);
	}

	@Override
	public List<PageData> listPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("PaymentMapper.listPage", page);
	}

	@Override
	public List<PageData> findEmpByRoomId(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("PaymentMapper.findEmpByRoomId", pd);
	}

	@Override
	public List<PageData> findRentlistPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("PaymentMapper.findRentlistPage", page);
	}
	
}
