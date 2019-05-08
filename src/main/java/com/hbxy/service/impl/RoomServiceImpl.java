package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.RoomService;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private DaoSupport dao;

	@Override
	public List<PageData> findByRoomType(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("RoomMapper.findByRoomType", pd);
	}

	@Override
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("RoomMapper.findById", pd);
	}
	
	/**
	 * Method name: deleteEmployeeById <BR>
	 * Description: 根据id假删除人员，并更新相应的房间人数，性别 <BR>
	 * Remark: <BR>
	 * @param pd
	 * @throws Exception  void<BR>
	 */
	public void deleteEmployeeById(PageData pd) throws Exception {
//		dao.delete("EmployeeMapper.deleteById", pd);
		dao.delete("EmployeeMapper.updateById", pd);
		dao.update("RoomMapper.updateTotalById2", pd);
		dao.update("RoomMapper.updateGenderById", pd);
	}

	@Override
	public List<PageData> findRoomByWE(Page page) throws Exception {
		return (List<PageData>) dao.findForList("RoomMapper.datalistPage", page);
	}

	@Override
	public List<PageData> findAlllistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("RoomMapper.findAlllistPage", page);
	}

	@Override
	public void insertRoom(PageData pd) throws Exception {
		dao.save("RoomMapper.insertRoom", pd);
	}

	@Override
	public void removeAll(int[] ids) throws Exception {
		dao.findForObject("RoomMapper.removeAll", ids);
	}

}
