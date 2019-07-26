package com.example.entry;

import java.io.Serializable;

public class Request implements Serializable{
	
	private static final long serialVersionUID = 540578313101688034L;
	public int id;
	public int offerId;
	public String userName;
	public String date;
	public String boraddingTime;
	public String address;
	public String district;
	public int passengers;
	public int status;
	@Override
	public String toString() {
		return "Request [id=" + id + ", offerId=" + offerId + ", userName="
				+ userName + ", date=" + date + ", boraddingTime="
				+ boraddingTime + ", address=" + address + ", passengers="
				+ passengers + ", status=" + status + "]";
	}
	

}
