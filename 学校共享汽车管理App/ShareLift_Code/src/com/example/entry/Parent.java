package com.example.entry;

public class Parent extends User{
	
	public String childName;
	public String childStudentID;
	public String childClassNumber;
	public String phoneNumber;
	public String homeAddress;
	public String district;
	public int seat;
	public String car;
	public String driver;
	@Override
	public String toString() {
		return "Parent [userName=" + userName + ", password=" + password
				+ ", childName=" + childName + ", childStudentID="
				+ childStudentID + ", childClassNumber=" + childClassNumber
				+ ", phoneNumber=" + phoneNumber + ", homeAddress="
				+ homeAddress + ", district=" + district + ", seat=" + seat
				+ ", car=" + car + ", driver=" + driver + "]";
	}
	
	

}
