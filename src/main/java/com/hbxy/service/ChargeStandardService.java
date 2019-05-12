package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface ChargeStandardService {

	/**
	 * 通过ID获取收费标准信息
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;

	/**
	 * 更新收费标准信息
	 * @param pd
	 * @throws Exception
	 */
	void updateById(PageData pd) throws Exception;

	/**
	 * 展示收费标准信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAll(Page page) throws Exception;

}
