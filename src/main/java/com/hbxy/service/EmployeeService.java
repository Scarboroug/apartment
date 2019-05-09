package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface EmployeeService {

	/**
	 *
	 * @param pd
	 * @throws Exception
	 */
	void updateEmpById(PageData pd) throws Exception;

	/**
	 *
	 * @param pd
	 * @throws Exception
	 */
	void save(PageData pd) throws Exception;

	/**
	 *
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> datalistPage(Page page) throws Exception;

	/**
	 *
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAlllistPage(Page page) throws Exception;

	/**
	 *
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;

	/**
	 *
	 * @param pd
	 * @throws Exception
	 */
	void deleteById(PageData pd) throws Exception;

	/**
	 *
	 * @param pd
	 * @throws Exception
	 */
	void updateWEPayTimeById(PageData pd) throws Exception;

}
