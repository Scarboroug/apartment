package com.hbxy.bean;

public class EmployeeBean extends BaseBean {

	private Integer empId;
	private String name;
	private String idNumber;
	private Integer gender;
	private String phone;
	private Integer roomId;
	private com.hbxy.bean.RoomBean room;
	private String province;
	private String city;
	private String area;
	private String street;
	private String detailed;
	private String enterTime;
	private String paymentTime;
	private Integer mortgageStatus;
	private Integer deleteFlag = 0;
	
	private String startTime;
	private String endTime;
	
	public EmployeeBean(){}

	public EmployeeBean(String name, String idNumber, Integer gender,
                        String phone, Integer roomId, com.hbxy.bean.RoomBean room, String province,
                        String city, String area, String street, String detailed,
                        String enterTime, String paymentTime, Integer mortgageStatus,
                        Integer deleteFlag)
	{
		this.name = name;
		this.idNumber = idNumber;
		this.gender = gender;
		this.phone = phone;
		this.roomId = roomId;
		this.room = room;
		this.province = province;
		this.city = city;
		this.area = area;
		this.street = street;
		this.detailed = detailed;
		this.enterTime = enterTime;
		this.paymentTime = paymentTime;
		this.mortgageStatus = mortgageStatus;
		this.deleteFlag = deleteFlag;
	}


	public Integer getEmpId()
	{
		return empId;
	}

	public void setEmpId(Integer empId)
	{
		this.empId = empId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIdNumber()
	{
		return idNumber;
	}

	public void setIdNumber(String idNumber)
	{
		this.idNumber = idNumber;
	}

	public Integer getGender()
	{
		return gender;
	}

	public void setGender(Integer gender)
	{
		this.gender = gender;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Integer getRoomId()
	{
		return roomId;
	}

	public void setRoomId(Integer roomId)
	{
		this.roomId = roomId;
	}

	public com.hbxy.bean.RoomBean getRoom()
	{
		return room;
	}

	public void setRoom(RoomBean room)
	{
		this.room = room;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getDetailed()
	{
		return detailed;
	}

	public void setDetailed(String detailed)
	{
		this.detailed = detailed;
	}

	public String getEnterTime()
	{
		return enterTime;
	}

	public void setEnterTime(String enterTime)
	{
		this.enterTime = enterTime;
	}

	public String getPaymentTime()
	{
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime)
	{
		this.paymentTime = paymentTime;
	}

	public Integer getMortgageStatus()
	{
		return mortgageStatus;
	}

	public void setMortgageStatus(Integer mortgageStatus)
	{
		this.mortgageStatus = mortgageStatus;
	}

	public Integer getDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag)
	{
		this.deleteFlag = deleteFlag;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

}
