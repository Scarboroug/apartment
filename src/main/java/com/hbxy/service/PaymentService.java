package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface PaymentService {

	/**
	 * 查询所有已缴水电费的用户
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> listPage(PageData pd) throws Exception;

	/**
	 * 查询所有未缴水电费的用户
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> listPage(Page page) throws Exception;

	/**
	 * 通过id 获取指定人员信息
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> findEmpByRoomId(PageData pd) throws Exception;

	/**
	 * 查询所有缴费房租信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findRentlistPage(Page page) throws Exception;

}
