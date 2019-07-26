package com.test.seat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.omg.CosNaming.IstringHelper;

import com.test.bean.Ticket;

public class SeatBoard extends JPanel {

	private final Color BACKGROUND = new Color(245, 250, 255);

	private final String[] CHARACTERS = { "A", "B", "C", "D", "E", "F", "H", "I" };

	SingleSeat[][] seats;

	/**
	 * @param ticket
	 * 
	 * the constructor of SeatBoard, the page which display the image of seats.
	 * 
	 */
	public SeatBoard(Ticket ticket) {

		this.setBackground(BACKGROUND);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		String[][] seatsStrings = OriginMethods.getScreenSeatsInString(ticket.getScreen());
		int h_count = seatsStrings.length, w_count = seatsStrings[1].length;
		seats = new SingleSeat[h_count][w_count];
		int availableNo = 1;

		JPanel seatPanel = new JPanel();
		seatPanel.setBackground(null);

		GridLayout seatGridLayout = new GridLayout(h_count, w_count + 2);
		seatPanel.setLayout(seatGridLayout);

		JButton[] characterLabel = new JButton[h_count * 2];
		for (int i = 0; i < h_count * 2; i++) {
			if (i % 2 == 0) {
				characterLabel[i] = new JButton("<html><p style='font-size:18px;font-family:arial;'>"
						+ CHARACTERS[seatsStrings.length - 1 - i / 2] + "</p></html>");
				characterLabel[i + 1] = new JButton("<html><p style='font-size:18px;font-family:arial;'>"
						+ CHARACTERS[seatsStrings.length - 1 - i / 2] + "</p></html>");
			}
			characterLabel[i].setBackground(null);
			characterLabel[i].setFocusPainted(false);
			characterLabel[i].setBorder(null);
			// characterLabel[i].setEnabled(false);
			characterLabel[i].setContentAreaFilled(false);
		}

		for (int i = 0; i < h_count; i++) {
			availableNo = 1;
			for (int j = w_count - 1; j >= 0; j--) {
				seats[i][j] = new SingleSeat();

				if (seatsStrings[i][j].equals("1")) {
					seats[i][j].getChair().setText("<html><p style='font-weight:bold;font-size:12px;font-family:arial'>"
							+ CHARACTERS[seatsStrings.length - 1 - i] + availableNo + "</p></html>");
					seats[i][j].setPosition(CHARACTERS[seatsStrings.length - 1 - i] + availableNo++);
					seats[i][j].setState(Integer.parseInt(seatsStrings[i][j]));
					seats[i][j].getChair().setBackground(SingleSeat.STATE_COLORS[Integer.parseInt(seatsStrings[i][j])]);
					seats[i][j].repaint();
				} else
					seats[i][j].setVisible(false);
			}
		}

		int cl_no = 0;
		for (int i = 0; i < h_count; i++) {
			seatPanel.add(characterLabel[cl_no++]);
			for (int j = 0; j < w_count; j++)
				seatPanel.add(seats[i][j]);
			seatPanel.add(characterLabel[cl_no++]);
		}

		JPanel screenPanel = new JPanel();
		screenPanel.setBackground(null);
		screenPanel.setBorder(null);
		screenPanel.setLayout(new FlowLayout(1, 0, 0));

		JLabel screenButton = new JLabel("<html><p style='font-size:24px;font-family:arial'>SCREEN</p></html>");
		screenButton.setOpaque(true);
		screenButton.setBackground(new Color(240, 200, 120));
		screenButton.setOpaque(true);

		Border b1 = BorderFactory.createLineBorder(Color.BLACK, 2);
		Border b2 = BorderFactory.createEmptyBorder(5, 25, 5, 25);
		screenButton.setBorder(BorderFactory.createCompoundBorder(b1, b2));

		screenPanel.add(screenButton);

		this.setLayout(new BorderLayout(0, 24));

		this.add(seatPanel, BorderLayout.CENTER);
		this.add(screenPanel, BorderLayout.SOUTH);

		CheckSeats(ticket, seats);
		// ListenSeats(seats);

	}

	private void CheckSeats(Ticket ticket, SingleSeat[][] seats) {
		// TODO Auto-generated method stub
		Ticket[] existedTickets = OriginMethods.getTickets();

		for (int i = 0; i < existedTickets.length; i++) {

			// System.out.println("4." + existedTickets[i].getTime() + "///" +
			// ticket.getTime());
			System.out.println("5. " + existedTickets[i].getMovie().replaceAll("_", " ") + "///" + ticket.getMovie());

			if (existedTickets[i].getMovie().replaceAll("_", " ").equals(ticket.getMovie())
					&& existedTickets[i].getDate().equals(ticket.getDate())
					&& existedTickets[i].getTime().equals(ticket.getTime())
					&& existedTickets[i].getScreen().equals(ticket.getScreen()))
				for (int j = 0; j < seats.length; j++)
					for (int k = 0; k < seats[j].length; k++)
						if (existedTickets[i].getSeat().equals(seats[j][k].getPosition())) {
							seats[j][k].getChair().setBackground(SingleSeat.STATE_COLORS[3]);
							seats[j][k].setState(3);
							seats[j][k].repaint();
						}
		}

	}

	private void ListenSeats(final SingleSeat[][] seats) {
		// TODO Auto-generated method stub
		for (int i = 0; i < seats.length; i++)
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j].getChair().addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						for (int i = 0; i < seats.length; i++)
							for (int j = 0; j < seats[i].length; j++)
								if (e.getSource() == seats[i][j].getChair())
									if (seats[i][j].getState() != 3) {
										seats[i][j].setState(3 - seats[i][j].getState());
										seats[i][j].getChair()
												.setBackground(SingleSeat.STATE_COLORS[seats[i][j].getState()]);
										seats[i][j].repaint();
									}
					}
				});
			}

	}

	public SingleSeat[][] getSeats() {
		return seats;
	}

	public void setSeats(SingleSeat[][] seats) {
		this.seats = seats;
	}

}
