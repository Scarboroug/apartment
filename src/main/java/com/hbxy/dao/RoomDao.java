package com.hbxy.dao;

import org.apache.ibatis.annotations.Param;

import com.hbxy.bean.RoomBean;

public interface RoomDao {

	/**
	 * 根据id查询房间信息
	 * @param id
	 * @return
	 */
	RoomBean findById(@Param("id") Integer id);
	
	/**
	 * 插入房间信息
	 * @param room
	 */
	void insertRoom(RoomBean room);

}
