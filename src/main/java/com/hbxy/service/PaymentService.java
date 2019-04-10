package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface PaymentService
{

	public List<PageData> listPage(PageData pd) throws Exception;
	
	public List<PageData> listPage(Page page) throws Exception;
	
	public List<PageData> findEmpByRoomId(PageData pd) throws Exception;
	
	public List<PageData> findRentlistPage(Page page) throws Exception;

}
