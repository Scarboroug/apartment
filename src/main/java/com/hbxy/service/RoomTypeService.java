package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface RoomTypeService
{
	
	public PageData findById(PageData pd) throws Exception;
	
	public void updateRoomType(PageData pd) throws Exception;
	
	public List<PageData> findAlllistPage(Page page) throws Exception;
}
