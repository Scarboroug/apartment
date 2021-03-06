package com.hbxy.bean;

public class RoomTypeBean extends BaseBean {

	//房间类型ID
	private Integer roomTypeId;
	//房间类型
	private String roomType;
	//租金
	private Double rental;
	
	public RoomTypeBean(){}
	
	public RoomTypeBean(String roomType, Double rental)
	{
		this.roomType = roomType;
		this.rental = rental;
	}

	public RoomTypeBean(Integer roomTypeId, String roomType, Double rental)
	{
		this.roomTypeId = roomTypeId;
		this.roomType = roomType;
		this.rental = rental;
	}

	public Integer getRoomTypeId()
	{
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId)
	{
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType()
	{
		return roomType;
	}

	public void setRoomType(String roomType)
	{
		this.roomType = roomType;
	}

	public Double getRental()
	{
		return rental;
	}

	public void setRental(Double rental)
	{
		this.rental = rental;
	}

}
