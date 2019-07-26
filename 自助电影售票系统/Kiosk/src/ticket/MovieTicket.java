package ticket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MovieTicket {

	private JLabel ticketNoLabel;

	public void type(final com.test.bean.Ticket t, ArrayList<com.test.bean.Ticket> list, JPanel j) {

		JPanel panel = new JPanel();
		j.add(panel);
		j.setBackground(new Color(250, 245, 255));

		JPanel small = new JPanel(new FlowLayout(0));
		small.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.add(small);
		panel.setBackground(new Color(250, 245, 255));
		small.setPreferredSize(new Dimension(540, 105));
		small.setBackground(Color.WHITE);

		final double origin = 16.00;

		Font font = new Font("Arial", Font.BOLD, 16);

		ticketNoLabel = new JLabel();
		ticketNoLabel.setFont(font);
		small.add(ticketNoLabel);
		small.add(Box.createRigidArea(new Dimension(500, 0)));

		JLabel date = new JLabel();
		date.setText("Date: " + t.getDate() + "    ");
		date.setFont(font);
		small.add(date);

		JLabel movie = new JLabel();
		movie.setText("Movie: " + t.getMovie() + "    ");
		movie.setFont(font);
		small.add(movie);

		JLabel screen = new JLabel();
		screen.setText("Screen: " + t.getSeat() + "    ");
		screen.setFont(font);
		small.add(screen);

		JLabel seat = new JLabel();
		seat.setText("Seat: " + t.getSeat() + "    ");
		seat.setFont(font);
		small.add(seat);

		JLabel time = new JLabel();
		time.setText("Time: " + t.getTime() + "    ");
		time.setFont(font);
		small.add(time);

		final JLabel pri = new JLabel();
		pri.setText("Price: " + String.valueOf(origin) + "    ");
		pri.setPreferredSize(new Dimension(100, 30));
		pri.setFont(font);
		small.add(pri);
		small.add(Box.createRigidArea(new Dimension(45, 0)));

		JLabel type = new JLabel();
		type.setText("Type: ");
		type.setFont(font);
		small.add(type);

		String com[] = { "Adult", "Child", "Senior", "Student" };
		JComboBox comboBox = new JComboBox(com);
		comboBox.setPreferredSize(new Dimension(90, 30));
		comboBox.setBackground(new Color(240, 250, 255));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String person = (String) ((JComboBox) e.getSource()).getSelectedItem();
				String price;
				String type;

				if (person.equals("Child")) {
					price = (new DecimalFormat("#.00")).format(0.5 * origin);
					t.setPrice(Double.parseDouble(price));
					t.setType("Child");
					pri.setText("Price: " + String.valueOf(t.getPrice()));

					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("ticket.txt", true));

						writer.write("Date\t" + t.getDate());
						writer.write("\n");
						writer.write("Movie\t" + t.getMovie());
						writer.write("\n");
						writer.write("Screen\t" + t.getScreen());
						writer.write("\n");
						writer.write("Seat\t" + t.getSeat());
						writer.write("\n");
						writer.write("Ticket ID\t" + t.getTicket_ID());
						writer.write("\n");
						writer.write("Price\t" + t.getPrice());
						writer.write("\n");
						writer.write("Time\t" + t.getTime());
						writer.write("\n");
						writer.write("Type\t" + t.getType());
						writer.write("\n");
						writer.close();

					} catch (Exception e1) {
						System.out.println("Read File fail");
					}

				} else if (person.equals("Adult")) {
					price = (new DecimalFormat("#.00")).format(origin);
					t.setPrice(Double.parseDouble(price));
					t.setType("Adult");
					pri.setText("Price: " + String.valueOf(t.getPrice()));

					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("ticket.txt", true));
						writer.write("Date\t" + t.getDate());
						writer.write("\n");
						writer.write("Movie\t" + t.getMovie());
						writer.write("\n");
						writer.write("Screen\t" + t.getScreen());
						writer.write("\n");
						writer.write("Seat\t" + t.getSeat());
						writer.write("\n");
						writer.write("Ticket ID\t" + t.getTicket_ID());
						writer.write("\n");
						writer.write("Price\t" + t.getPrice());
						writer.write("\n");
						writer.write("Time\t" + t.getTime());
						writer.write("\n");
						writer.write("Type\t" + t.getType());
						writer.write("\n");
						writer.close();

					} catch (Exception e1) {
						System.out.println("Read File fail");
					}

				} else if (person.equals("Senior")) {
					price = (new DecimalFormat("#.00")).format(0.8 * origin);
					t.setPrice(Double.parseDouble(price));
					t.setType("Senior");
					pri.setText("Price: " + String.valueOf(t.getPrice()));

					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("ticket.txt", true));
						writer.write("Date\t" + t.getDate());
						writer.write("\n");
						writer.write("Movie\t" + t.getMovie());
						writer.write("\n");
						writer.write("Screen\t" + t.getScreen());
						writer.write("\n");
						writer.write("Seat\t" + t.getSeat());
						writer.write("\n");
						writer.write("Ticket ID\t" + t.getTicket_ID());
						writer.write("\n");
						writer.write("Price\t" + t.getPrice());
						writer.write("\n");
						writer.write("Time\t" + t.getTime());
						writer.write("\n");
						writer.write("Type\t" + t.getType());
						writer.write("\n");
						writer.close();

					} catch (Exception e1) {
						System.out.println("Read File fail");
					}

				} else {
					price = (new DecimalFormat("#.00")).format(0.85 * origin);
					t.setPrice(Double.parseDouble(price));
					t.setType("Student");
					pri.setText("Price: " + String.valueOf(t.getPrice()));

					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("ticket.txt", true));
						writer.write("Date\t" + t.getDate());
						writer.write("\n");
						writer.write("Movie\t" + t.getMovie());
						writer.write("\n");
						writer.write("Screen\t" + t.getScreen());
						writer.write("\n");
						writer.write("Seat\t" + t.getSeat());
						writer.write("\n");

						writer.write("Ticket ID\t" + t.getTicket_ID());
						writer.write("\n");
						writer.write("Price\t" + t.getPrice());
						writer.write("\n");
						writer.write("Time\t" + t.getTime());
						writer.write("\n");
						writer.write("Type\t" + t.getType());
						writer.write("\n");
						writer.close();

					} catch (Exception e1) {
						System.out.println("Read File fail");
					}

				}

			}

		});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		small.add(comboBox);

	}

	public JLabel getTicketNoLabel() {
		return ticketNoLabel;
	}

	public void setTicketNoLabel(JLabel ticketNoLabel) {
		this.ticketNoLabel = ticketNoLabel;
	}

}
