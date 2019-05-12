package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface RoomTypeService {

	/**
	 * 根据ID查询租金信息
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;

	/**
	 * 租金持久化
	 * @param pd
	 * @throws Exception
	 */
	void updateRoomType(PageData pd) throws Exception;

	/**
	 * 查看所有租金标准列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAlllistPage(Page page) throws Exception;

}
