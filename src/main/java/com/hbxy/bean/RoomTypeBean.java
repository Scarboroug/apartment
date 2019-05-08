package com.hbxy.bean;

public class RoomTypeBean extends BaseBean {

	private Integer roomTypeId;
	private String roomType;
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
