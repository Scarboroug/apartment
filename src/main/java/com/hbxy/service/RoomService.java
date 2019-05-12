package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface RoomService {

	/**
	 * 根据ID查询房间入住情况
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> findByRoomType(PageData pd) throws Exception;

	/**
	 * 根据房间ID 查询房间表所有字段
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;
	
	/**
	 * 根据id 假删除人员，并更新相应的房间人数，性别
	 * @param pd
	 * @throws Exception
	 */
	void deleteEmployeeById(PageData pd) throws Exception;

	/**
	 * 查询所有未录入水电用量的用户
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findRoomByWE(Page page) throws Exception;

	/**
	 * 展示所有房间
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findAlllistPage(Page page) throws Exception;

	/**
	 * 新增房间
	 * @param pd
	 * @throws Exception
	 */
	void insertRoom(PageData pd) throws Exception;

	/**
	 * 批量删除房间
	 * @param ids
	 * @throws Exception
	 */
	void removeAll(int[] ids) throws Exception;

}
