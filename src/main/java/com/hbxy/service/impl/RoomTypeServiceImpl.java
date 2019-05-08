package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.RoomTypeService;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	@Autowired
	private DaoSupport dao;

	@Override
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("RoomTypeMapper.findById", pd);
	}

	@Override
	public void updateRoomType(PageData pd) throws Exception {
		dao.findForObject("RoomTypeMapper.updateRoomType", pd);
	}

	@Override
	public List<PageData> findAlllistPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("RoomTypeMapper.findAlllistPage", page);
	}

}
