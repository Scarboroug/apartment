package com.hbxy.dao;

import org.apache.ibatis.annotations.Param;

import com.hbxy.bean.RoomTypeBean;

public interface RoomTypeDao {

	/**
	 * 添加房间类型
	 * @param roomType
	 */
	void insertRoomType(RoomTypeBean roomType);
	
	/**
	 * 根据id查询房间类型信息
	 * @param id
	 * @return
	 */
	RoomTypeBean findById(@Param("id") Integer id);
	
	/**
	 * 根据id删除房间类型信息
	 * @param id
	 */
	void deleteById(@Param("id") Integer id);
	
	/**
	 * 更新房间类型信息
	 * @param roomType
	 */
	void updateRoomType(RoomTypeBean roomType);

}
