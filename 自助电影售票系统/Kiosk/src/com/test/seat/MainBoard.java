package com.test.seat;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.test.bean.Ticket;

/**
 * @author KaruBIN
 *
 */
public class MainBoard extends JFrame {

	private SeatBoard seatBoard;
	private JLabel countLabel;
	private ArrayList<Ticket> ticketList;
	private JButton cancelButton;
	private JButton submitButton;

	private Ticket[] existedTickets;

	/**
	 * the constructor of MainBoard, the page which enable user to select the
	 * seat the prefer.
	 * 
	 * @param ticket, the details of ticket
	 */
	public MainBoard(Ticket ticket) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 720);
		this.setResizable(false);
		this.setLocation(150, 90);
		this.getContentPane().setBackground(new Color(250, 245, 255));

		Container container = this.getContentPane();
		container.setSize(getWidth(), getHeight());
		this.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(null);
		titlePanel.setLayout(new FlowLayout(1, 12, 12));
		JLabel titleLabel = new JLabel("<html><p style='font-size:30px;font-family:arial;font-weight:bold'>"
				+ ticket.getScreen() + "</p></html>");
		titlePanel.setMaximumSize(new Dimension(getWidth(), 30));
		titlePanel.add(titleLabel);
		container.add(titlePanel);

		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(null);
		detailPanel.setLayout(new FlowLayout(1, 0, 0));
		JLabel detailLabel = new JLabel("<html><p style='font-size:18px;font-family:arial;'>" + ticket.getMovie() + "  "
				+ ticket.getTime() + "</p></html>");
		detailPanel.add(detailLabel);
		container.add(detailPanel);

		JPanel anotherPanel = new JPanel(new FlowLayout());
		anotherPanel.setBackground(null);
		anotherPanel.setMaximumSize(new Dimension(getWidth(), 240));
		seatBoard = new SeatBoard(ticket);
		anotherPanel.add(seatBoard);
		container.add(anotherPanel);
		SetListenerSeatBoard(seatBoard);

		JPanel samplePanel = SetSamplePanel();
		container.add(samplePanel);

		JPanel countPanel = SetCountPanel();
		container.add(countPanel);

		JPanel bottomJPanel = SetBottomPanel(ticket);
		container.add(bottomJPanel);

		this.setVisible(true);

	}

	private void SetListenerSeatBoard(SeatBoard seatBoard) {
		// TODO Auto-generated method stub
		final SingleSeat[][] seats = seatBoard.getSeats();

		for (int i = 0; i < seats.length; i++)
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j].getChair().addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						int count = 0;
						for (int i = 0; i < seats.length; i++)
							for (int j = 0; j < seats[i].length; j++) {
								if (e.getSource() == seats[i][j].getChair())
									if (seats[i][j].getState() != 3) {
										seats[i][j].setState(3 - seats[i][j].getState());
										seats[i][j].getChair()
												.setBackground(SingleSeat.STATE_COLORS[seats[i][j].getState()]);
										seats[i][j].repaint();
									}
								if (seats[i][j].getState() == 2)
									count++;
							}
						countLabel.setText("<html><p style='font-size:18px;font-family:arial'>" + count
								+ " SEAT(S) SELECTED</p></html>");
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}
				});
			}

	}

	private JPanel SetCountPanel() {
		// TODO Auto-generated method stub
		JPanel countPanel = new JPanel();
		countPanel.setBackground(null);

		countLabel = new JLabel();
		countLabel.setText("<html><p style='font-size:18px;font-family:arial'>0 SEAT(S) SELECTED</p></html>");
		countPanel.add(countLabel);

		return countPanel;
	}

	private JPanel SetBottomPanel(final Ticket ticket) {
		// TODO Auto-generated method stub
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(null);

		Border b1 = BorderFactory.createLineBorder(Color.BLACK, 2);
		Border b2 = BorderFactory.createEmptyBorder(5, 10, 5, 10);

		cancelButton = new JButton("<html><p style='font-size:18px;font-family:arial'>CANCEL</p></html>");
		cancelButton.setFocusPainted(false);
		cancelButton.setOpaque(true);
		cancelButton.setBackground(new Color(230, 170, 160));
		cancelButton.setBorder(BorderFactory.createCompoundBorder(b1, b2));

		submitButton = new JButton("<html><p style='font-size:18px;font-family:arial'>CONFIRM</p></html>");
		submitButton.setFocusPainted(false);
		submitButton.setOpaque(true);
		submitButton.setBackground(new Color(160, 170, 230));
		submitButton.setBorder(BorderFactory.createCompoundBorder(b1, b2));

		bottomPanel.add(cancelButton);
		bottomPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		bottomPanel.add(submitButton);

		ticketList = new ArrayList<Ticket>();

		submitButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ValueData(ticket);
			}

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

		});

		return bottomPanel;
	}

	protected void ValueData(Ticket ticket) {
		// TODO Auto-generated method stub
		int h = seatBoard.getSeats().length, w = seatBoard.getSeats()[0].length;
		Ticket[] tempTickets = new Ticket[99];
		int ticketNo = 0;
		ticketList.clear();

		String randomTicket_ID = "";
		boolean flag = true;
		existedTickets = OriginMethods.getTickets();

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (seatBoard.getSeats()[i][j].getState() == 2) {
					tempTickets[ticketNo] = new Ticket();
					tempTickets[ticketNo].setMovie(ticket.getMovie());
					tempTickets[ticketNo].setDate(ticket.getDate());
					tempTickets[ticketNo].setTime(ticket.getTime());
					tempTickets[ticketNo].setScreen(ticket.getScreen());
					tempTickets[ticketNo].setSeat(seatBoard.getSeats()[i][j].getPosition());

					while (flag == false || randomTicket_ID.length() == 0) {
						randomTicket_ID = OriginMethods.produceTicket_ID();
						for (int k = 0; k < existedTickets.length; k++)
							if (existedTickets[k].getTicket_ID().equals(randomTicket_ID))
								flag = false;
					}

					tempTickets[ticketNo].setTicket_ID(randomTicket_ID + "");
					randomTicket_ID = "";
					ticketList.add(tempTickets[ticketNo++]);
				}

		// for (Ticket t : ticketList) {
		// System.out.println(t.getSeat());
		// System.out.println(t.getTicket_ID());
		// }
	}

	private JPanel SetSamplePanel() {
		// TODO Auto-generated method stub
		String[] state = { " AVAILABLE ", " SELECTED ", " HAS BEEN SELECTED " };

		JPanel samplePanel = new JPanel();
		samplePanel.setBackground(null);
		samplePanel.setMinimumSize(new Dimension(getWidth(), 30));
		samplePanel.setLayout(new FlowLayout(1, 12, 12));

		JButton[] stateSample = new JButton[3];
		JLabel[] stateText = new JLabel[3];

		for (int i = 0; i < 3; i++) {
			stateSample[i] = new JButton("              ");
			stateSample[i].setOpaque(true);
			stateSample[i].setSize(60, 40);
			stateSample[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			stateSample[i].setEnabled(false);
			stateSample[i].setBackground(SingleSeat.STATE_COLORS[i + 1]);

			stateText[i] = new JLabel();
			stateText[i].setText(
					"<html><p style:'font-family:arial;font-size:12px;font-weight:bold'>" + state[i] + "</p></html>");

			samplePanel.add(stateSample[i]);
			samplePanel.add(stateText[i]);
		}

		return samplePanel;
	}

	public SeatBoard getSeatBoard() {
		return seatBoard;
	}

	public void setSeatBoard(SeatBoard seatBoard) {
		this.seatBoard = seatBoard;
	}

	public JLabel getCountLabel() {
		return countLabel;
	}

	public void setCountLabel(JLabel countLabel) {
		this.countLabel = countLabel;
	}

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

}
