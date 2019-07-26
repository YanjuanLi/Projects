package com.example.entry;

import java.io.Serializable;

public class Offer implements Serializable{
	

	private static final long serialVersionUID = 4363470437547915249L;
	public int id;
	public int requestId;
	public String userName;
	public String date;
	public String boraddingTime;
	public String address;
	public String district;
	public int seat;
	
	public int status;
	@Override
	public String toString() {
		return "Offer [id=" + id + ", requestId=" + requestId + ", userName="
				+ userName + ", date=" + date + ", boraddingTime="
				+ boraddingTime + ", address=" + address + ", seat=" + seat
				+ ", status=" + status + "]";
	}
	
}
