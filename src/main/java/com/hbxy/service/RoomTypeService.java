package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService
{
	@Autowired
	private DaoSupport dao;
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("RoomTypeMapper.findById", pd);
	}
	
	public void updateRoomType(PageData pd) throws Exception
	{
		dao.findForObject("RoomTypeMapper.updateRoomType", pd);
	}
	
	public List<PageData> findAlllistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("RoomTypeMapper.findAlllistPage", page);
	}
}
