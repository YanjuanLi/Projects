package ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ticket {

	/**
	 * Though it is also named as Ticket, but it carry a different funtion, as a
	 * constructor of the page to choose the type of ticket(s).
	 */

	private String movie;
	private String time;
	private String screen;
	private String seat;
	private double price;
	private String date;
	private String ticketID;
	private String type;

	private JButton next;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
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

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void first() {
		JFrame frame = new JFrame();
		frame = new JFrame();
		frame.setSize(800, 720);
		frame.setBackground(new Color(250, 245, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JFrame showTIcketSelectPanel(ArrayList<com.test.bean.Ticket> ticketList) {

		// Ticket[] tickets = new Ticket[5];

		MovieTicket m = new MovieTicket();
		final JFrame j = new JFrame();
		j.setBackground(new Color(250, 245, 255));
		j.getContentPane().setBackground(new Color(250, 245, 255));
		j.setSize(800, 720);
		j.setResizable(false);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.getContentPane().setLayout(new GridLayout(0, 1));
		j.setLocation(150, 90);

		JPanel p = new JPanel();
		p.setBackground(new Color(250, 245, 255));
		p.setLayout(new GridLayout(0, 1));

		j.add(p);

		JLabel choose = new JLabel("The seats you have chosen:");
		choose.setFont(new Font("Arial", Font.BOLD, 25));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.setBackground(null);
		panel2.setMaximumSize(new Dimension(540, 120));
		panel2.add(choose);
		p.add(panel2, BorderLayout.LINE_START);

		next = new JButton("Next");
		next.setOpaque(true);
		next.setBackground(new Color(180, 190, 240));
		next.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		next.setPreferredSize(new Dimension(120, 40));

		JScrollPane scroll = new JScrollPane(p);
		scroll.setBackground(new Color(250, 245, 255));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400, 200));
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		j.add(scroll);

		for (int i = 0; i < ticketList.size(); i++) {
			m.type(ticketList.get(i), ticketList, p);
			m.getTicketNoLabel()
					.setText("<html><p style='font-size:18px;font-weight:bold;'>TICEKT " + (i + 1) + ": </p></html>");
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ticket.txt", true));

			for (int h = 0; h < ticketList.size(); h++) {
				writer.write("Date\t" + (ticketList.get(h)).getDate());
				writer.write("\n");
				writer.write("Movie\t" + (ticketList.get(h)).getMovie());
				writer.write("\n");
				writer.write("Screen\t" + (ticketList.get(h)).getScreen());
				writer.write("\n");
				writer.write("Seat\t" + (ticketList.get(h)).getSeat());
				writer.write("\n");
				writer.write("Ticket ID\t" + (ticketList.get(h)).getTicket_ID());
				writer.write("\n");
				writer.write("Price\t" + (ticketList.get(h)).getPrice());
				writer.write("\n");
				writer.write("Time\t" + (ticketList.get(h)).getTime());
				writer.write("\n");
				writer.write("Type\tAdult");
				writer.write("\n");
				// System.out.println("TOM");
			}
			writer.close();

		} catch (Exception e1) {
			System.out.println("Read File fail");
		}

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setBackground(new Color(250, 245, 255));
		panel.add(next);
		next.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e2) {
				j.setVisible(false);

				Movie m = new Movie();
				m.readFile();

			}

		}

		);
		p.add(panel, BorderLayout.SOUTH);

		j.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("./ticket.txt"));
					writer.write("");
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("clear");
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		return j;

	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}
}
