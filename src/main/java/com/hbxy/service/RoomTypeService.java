package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface RoomTypeService
{
	
	PageData findById(PageData pd) throws Exception;
	
	void updateRoomType(PageData pd) throws Exception;
	
	List<PageData> findAlllistPage(Page page) throws Exception;
}
