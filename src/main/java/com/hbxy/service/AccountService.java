package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface AccountService {

	/**
	 * 展示账户信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findlistPage(Page page) throws Exception;

	/**
	 * 通过ID 获取账户信息
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;

	/**
	 * 更新账户信息
	 * @param pd
	 * @throws Exception
	 */
	void updateById(PageData pd) throws Exception;

	/**
	 * 保存账户信息
	 * @param pd
	 * @throws Exception
	 */
	void save(PageData pd) throws Exception;

	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	void removeAll(int[] ids) throws Exception;

	/**
	 * 验重登录名
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAllLogin(PageData pd) throws Exception;

}
