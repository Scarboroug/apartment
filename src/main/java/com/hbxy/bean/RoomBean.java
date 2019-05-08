package com.hbxy.bean;


public class RoomBean {

	private Integer roomId;
	private Integer roomTypeId;
	private RoomTypeBean roomType;
	private String roomNumber;
	private Integer gender;
	private Integer total;
	
	public RoomBean(){}

	public RoomBean(Integer roomId, Integer roomTypeId, RoomTypeBean roomType,
			String roomNumber, Integer gender, Integer total)
	{
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.gender = gender;
		this.total = total;
	}

	public Integer getRoomId()
	{
		return roomId;
	}

	public void setRoomId(Integer roomId)
	{
		this.roomId = roomId;
	}

	public Integer getRoomTypeId()
	{
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId)
	{
		this.roomTypeId = roomTypeId;
	}

	public RoomTypeBean getRoomType()
	{
		return roomType;
	}

	public void setRoomType(RoomTypeBean roomType)
	{
		this.roomType = roomType;
	}

	public String getRoomNumber()
	{
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	public Integer getGender()
	{
		return gender;
	}

	public void setGender(Integer gender)
	{
		this.gender = gender;
	}

	public Integer getTotal()
	{
		return total;
	}

	public void setTotal(Integer total)
	{
		this.total = total;
	}

}
