package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface PaymentService {

	/**
	 *
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> listPage(PageData pd) throws Exception;

	/**
	 *
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> listPage(Page page) throws Exception;

	/**
	 *
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> findEmpByRoomId(PageData pd) throws Exception;

	/**
	 *
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findRentlistPage(Page page) throws Exception;

}
