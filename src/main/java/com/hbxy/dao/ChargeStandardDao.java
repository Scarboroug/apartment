package com.hbxy.dao;

import com.hbxy.bean.ChargeStandardBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChargeStandardDao
{
	/**
	 * 根据id查询收费标准信息
	 * @param id
	 * @return ChargeStandardBean
	 */
	ChargeStandardBean findById(@Param("id") Integer id);
	
	/**
	 *查询所有收费标准信息 
	 * @return List<ChargeStandardBean>
	 */
	List<ChargeStandardBean> findAll();
	
	/**
	 * 根据id更新收费标准
	 * @param chargeStandardBean
	 */
	void updateById(ChargeStandardBean chargeStandardBean);
}
