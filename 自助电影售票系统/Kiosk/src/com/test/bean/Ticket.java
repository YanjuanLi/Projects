package com.test.bean;

/**
 * @author KaruBIN
 *
 */
public class Ticket {

	// the Javabean which store the info of ticket.

	private String movie;
	private String date;
	private String time;
	private String screen;
	private String seat;
	private double price = 16;
	private String ticket_ID;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTicket_ID() {
		return ticket_ID;
	}

	public void setTicket_ID(String ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

}
