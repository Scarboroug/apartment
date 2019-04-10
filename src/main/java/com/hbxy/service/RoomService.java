package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.util.PageData;

import java.util.List;

public interface RoomService
{

	public List<PageData> findByRoomType(PageData pd) throws Exception;
	
	public PageData findById(PageData pd) throws Exception;
	
	/**
	 * Method name: deleteEmployeeById <BR>
	 * Description: 根据id假删除人员，并更新相应的房间人数，性别 <BR>
	 * Remark: <BR>
	 * @param pd
	 * @throws Exception  void<BR>
	 */
	public void deleteEmployeeById(PageData pd) throws Exception;
	
	public List<PageData> findRoomByWE(Page page) throws Exception;

	public List<PageData> findAlllistPage(Page page) throws Exception;
	
	public void insertRoom(PageData pd) throws Exception;
}
