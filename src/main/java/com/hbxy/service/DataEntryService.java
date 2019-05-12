package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface DataEntryService {

	/**
	 * 保存录入水电信息
	 * @param pd
	 * @throws Exception
	 */
	void save(PageData pd) throws Exception;

	/**
	 * 通过ID 更新用水量
	 * @param pd
	 * @throws Exception
	 */
	void updateById(PageData pd) throws Exception;

	/**
	 *  通过ID 获取用水量
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;

	/**
	 * 查询用水量列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> listPage(Page page) throws Exception;

	/**
	 * 更新水电使用总天数
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> updateDaysById(PageData pd) throws Exception;
	
}
