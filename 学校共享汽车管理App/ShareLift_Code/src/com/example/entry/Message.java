package com.example.entry;
/**
 * ÏûÏ¢
 *
 */
public class Message {

	public String date;
	public String message;
	public String userName;
	public long time;
	public Message(){
		
	}
	public Message(String from){
		String str[] = from.split("&&");
		date = str[0];
		message = str[1];
		userName = str[2];
		time = Long.parseLong(str[3]);
	}
	public  String to(){
		return date+"&&"+message+"&&"+userName+"&&"+time;
	}
}
