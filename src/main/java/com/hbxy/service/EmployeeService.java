package com.hbxy.service;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.util.PageData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeService")
@Transactional("transactionManager")
public class EmployeeService
{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	public void updateEmpById(PageData pd) throws Exception
	{
		dao.update("EmployeeMapper.updateEmpById", pd);
	}
	
	public void save(PageData pd) throws Exception
	{
		dao.save("EmployeeMapper.insertEmployee", pd);
		dao.update("RoomMapper.updateTotalById", pd);
	}
	
	public List<PageData> datalistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("EmployeeMapper.datalistPage", page);
	}
	
	public List<PageData> findAlllistPage(Page page) throws Exception
	{
		return (List<PageData>) dao.findForList("EmployeeMapper.findAlllistPage", page);
	}
	
	public PageData findById(PageData pd) throws Exception
	{
		return (PageData) dao.findForObject("EmployeeMapper.findById", pd);
	}
	
	public void deleteById(PageData pd) throws Exception
	{
		dao.delete("EmployeeMapper.deleteById", pd);
	}
	
	public void updateWEPayTimeById(PageData pd) throws Exception
	{
		dao.update("EmployeeMapper.updateWEPayTimeById", pd);
	}
}
