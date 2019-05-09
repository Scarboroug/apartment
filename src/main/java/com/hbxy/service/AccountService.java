package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface AccountService {

	/**
	 *
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findlistPage(Page page) throws Exception;

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
	void updateById(PageData pd) throws Exception;

	/**
	 *
	 * @param pd
	 * @throws Exception
	 */
	void save(PageData pd) throws Exception;

	/**
	 *
	 * @param ids
	 * @throws Exception
	 */
	void removeAll(int[] ids) throws Exception;

	/**
	 *
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAllLogin(PageData pd) throws Exception;

}
