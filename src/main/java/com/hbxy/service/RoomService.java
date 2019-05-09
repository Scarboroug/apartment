package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface RoomService {

	/**
	 *
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	List<PageData> findByRoomType(PageData pd) throws Exception;

	/**
	 *
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	PageData findById(PageData pd) throws Exception;
	
	/**
	 * Method name: deleteEmployeeById <BR>
	 * Description: 根据id假删除人员，并更新相应的房间人数，性别 <BR>
	 * Remark: <BR>
	 * @param pd
	 * @throws Exception  void<BR>
	 */
	void deleteEmployeeById(PageData pd) throws Exception;

	/**
	 *
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PageData> findRoomByWE(Page page) throws Exception;

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
	 * @throws Exception
	 */
	void insertRoom(PageData pd) throws Exception;

	/**
	 *
	 * @param ids
	 * @throws Exception
	 */
	void removeAll(int[] ids) throws Exception;

}
