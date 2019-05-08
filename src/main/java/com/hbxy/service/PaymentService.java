package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface PaymentService {

	List<PageData> listPage(PageData pd) throws Exception;
	
	List<PageData> listPage(Page page) throws Exception;
	
	List<PageData> findEmpByRoomId(PageData pd) throws Exception;
	
	List<PageData> findRentlistPage(Page page) throws Exception;

}
