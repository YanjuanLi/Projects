package com.test.seat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.test.bean.Ticket;

public class OriginMethods {

	/**
	 * 
	 * the function which get the details of seats of certain screen.
	 * 
	 * @param screenNo,
	 *            the No. of Screen
	 * @return seats, the details of seats
	 * 
	 */
	public static String[][] getScreenSeatsInString(String screenNo) {
		String[][] seats = null;
		String[][] tempSeats = new String[5][10];
		int seat_h = 0, seat_w = 0;
		File file = new File("file/screen_" + screenNo + ".txt");
		BufferedReader br = null;
		String line = null;
		int lineNo = 0;

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while ((line = br.readLine()) != null) {
				tempSeats[lineNo++] = line.split("\t");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < tempSeats.length; i++)
			if (tempSeats[i][0] != null)
				seat_h++;

		for (int i = 0; i < tempSeats[0].length; i++)
			if (tempSeats[0][i] != null)
				seat_w++;

		seats = new String[seat_h][seat_w];

		for (int i = 0; i < seats.length; i++)
			for (int j = 0; j < seats[i].length; j++)
				seats[i][j] = tempSeats[i][j];

		return seats;
	}

	/**
	 * 
	 * the function which get the details of the existed tickets.
	 * 
	 * @return tickets
	 * 
	 * 
	 */
	public static Ticket[] getTickets() {

		File ticketFolder = new File("tickets");
		String[] ticketsName = ticketFolder.list();
		File[] ticketFiles = new File[ticketsName.length];
		Ticket[] tickets = new Ticket[ticketsName.length];
		BufferedReader br = null;
		String[][] ticketInfo = new String[17][2];
		int no = 0;

		String line = null;

		for (int i = 0; i < ticketFiles.length; i++)
			ticketFiles[i] = new File("tickets/" + ticketsName[i]);

		for (int i = 0; i < ticketFiles.length; i++) {

			no = 0;
			br = null;
			tickets[i] = new Ticket();

			try {
				br = new BufferedReader(new FileReader(ticketFiles[i]));
				while ((line = br.readLine()) != null) {

					ticketInfo[no++] = line.split("\t");
				}

				tickets[i].setDate(ticketInfo[0][1]);
				tickets[i].setMovie(ticketInfo[1][1]);
				tickets[i].setScreen(ticketInfo[2][1]);
				tickets[i].setSeat(ticketInfo[3][1]);
				tickets[i].setTicket_ID(ticketInfo[4][1]);
				tickets[i].setPrice(Double.parseDouble(ticketInfo[5][1]));
				tickets[i].setTime(ticketInfo[6][1]);
				tickets[i].setType(ticketInfo[7][1]);

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return tickets;
	}

	/**
	 * the function to generate an ID of ticket.
	 * 
	 * @return ticket_ID
	 */

	public static String produceTicket_ID() {
		String ticket_ID = "";

		int singleNo = 0;

		for (int i = 0; i < 8; i++) {
			singleNo = (int) (Math.random() * 99) % 4 + 1;
			ticket_ID += singleNo;
		}

		return ticket_ID;
	}

}
