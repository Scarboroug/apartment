package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface EmployeeService {

	/**
	 * 人员信息更新
	 * @param pd
	 * @throws Exception
	 */
	void updateEmpById(PageData pd) throws Exception;

	/**
	 * 人员信息保存
	 * @param pd
	 * @throws Exception
	 */
	void save(PageData pd) throws Exception;

	/**
	 * 展示所有入住人员信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> datalistPage(Page page) throws Exception;

	/**
	 * 查询人员信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAlllistPage(Page page) throws Exception;

	/**
	 * 根据ID 查询人员信息
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;

	/**
	 * 根据ID 删除人员信息
	 * @param pd
	 * @throws Exception
	 */
	void deleteById(PageData pd) throws Exception;

	/**
	 * 水电缴费
	 * @param pd
	 * @throws Exception
	 */
	void updateWEPayTimeById(PageData pd) throws Exception;

}
