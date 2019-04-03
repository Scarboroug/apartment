package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService
{
	@Autowired
	private DaoSupport dao;
	
	public List<PageData> findByRoomType(PageData pd) throws Exception
	{
		return (List<PageData>) dao.findForList("RoomMapper.findByRoomType", pd);
	}
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("RoomMapper.findById", pd);
	}
	
	/**
	 * Method name: deleteEmployeeById <BR>
	 * Description: 根据id假删除人员，并更新相应的房间人数，性别 <BR>
	 * Remark: <BR>
	 * @param pd
	 * @throws Exception  void<BR>
	 */
	public void deleteEmployeeById(PageData pd) throws Exception
	{
//		dao.delete("EmployeeMapper.deleteById", pd);
		dao.delete("EmployeeMapper.updateById", pd);
		dao.update("RoomMapper.updateTotalById2", pd);
		dao.update("RoomMapper.updateGenderById", pd);
	}
	
	public List<PageData> findRoomByWE(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("RoomMapper.datalistPage", page);
	}
	public List<PageData> findAlllistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("RoomMapper.findAlllistPage", page);
	}
	
	public void insertRoom(PageData pd) throws Exception
	{
		dao.save("RoomMapper.insertRoom", pd);
	}
}
