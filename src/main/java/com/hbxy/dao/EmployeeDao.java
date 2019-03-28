package com.hbxy.dao;

import com.hbxy.bean.EmployeeBean;

import java.util.List;

public interface EmployeeDao
{
	
	/**
	 * 根据条件模糊查询员工信息
	 * @return List<EmployeeBean>
	 */
	List<EmployeeBean> findEmployee(EmployeeBean emp);
	
	/**
	 * 添加员工信息
	 * @param emp
	 */
	void insertEmployee(EmployeeBean emp);
	
	/**
	 * 统计根据条件查询结果数量
	 * @param emp
	 */
	int findCountByCondition(EmployeeBean emp);
}
