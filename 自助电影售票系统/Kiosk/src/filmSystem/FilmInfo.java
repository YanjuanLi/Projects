package filmSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FilmInfo {
	private File file = new File("files/schedule.csv");
	private com.test.bean.Ticket ticket = new com.test.bean.Ticket();

	private JFrame f = null;
	private String film;

	private JButton okButton;
	private JButton cancelButton;

	Font font = new Font("Arial", Font.BOLD, 26);
	Font font1 = new Font("Arial", Font.PLAIN, 16);

	/**
	 * A method to make f visible.
	 * 
	 * @param visible
	 *            whether f visible
	 */
	public void setVisible(boolean visible) {
		if (f != null) {
			f.setVisible(visible);
		}
	}

	public String[] findTime(int name, String screenNum) {
		String movieName = null;
		switch (name) {
		case 1:
			movieName = "KONG: SKULL ISLAND";
			break;
		case 2:
			movieName = "LOGAN";
			break;
		case 3:
			movieName = "BEAUTY AND THE BEAST";
			break;
		case 4:
			movieName = "MOONLIGHT";
			break;
		case 5:
			movieName = "LA LA LAND";
			break;
		}
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String[] time = new String[5];

			for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
				String[] s = temp.split(",");

				if (s[0].indexOf(screenNum.charAt(7)) >= 0 && s[1].equals(movieName)) {
					for (int i = 2; i < s.length; i++) {
						time[i - 2] = s[i];
					}
				}
			}

			br.close();
			fr.close();
			return time;
		} catch (IOException e) {
			System.out.println("1");
		}
		return null;
	}

	public FilmInfo(final int choice) {

		switch (choice) {
		case 1:
			film = "KONG: SKULL ISLAND";
			break;
		case 2:
			film = "LOGAN";
			break;
		case 3:
			film = "BEAUTY AND THE BEAST";
			break;
		case 4:
			film = "MOONLIGHT";
			break;
		case 5:
			film = "LA LA LAND";
			break;
		}
		f = new JFrame("Film Info");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new BorderLayout());
		((JComponent) contentPane).setBorder(new EmptyBorder(100, 100, 180, 100));
		contentPane.setBackground(new Color(250, 245, 255));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(150, 90);
		f.setResizable(false);

		// Add panel p1
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(250, 245, 255));
		p1.setLayout(new BorderLayout());
		contentPane.add(p1, BorderLayout.NORTH);

		ImageIcon img = new ImageIcon("images/" + choice + ".png");
		img.setImage(img.getImage().getScaledInstance(200, 270, Image.SCALE_DEFAULT));
		JLabel film_img = new JLabel(img);
		p1.add(film_img, BorderLayout.WEST);

		JPanel p12 = new JPanel();
		p12.setBackground(new Color(250, 245, 255));
		p12.setBorder(new EmptyBorder(20, 20, 20, 20));
		p12.setLayout(new BorderLayout());
		p1.add(p12, BorderLayout.CENTER);

		JLabel film_name = new JLabel();
		film_name = new JLabel("<html>BEAUTY AND THE BEAST</html>", JLabel.CENTER);
		switch (choice) {
		case 1:
			film_name.setText("KONG: SKULL ISLAND");
			break;
		case 2:
			film_name.setText("LOGAN ");
			break;
		case 3:
			film_name.setText("BEAUTY AND THE BEAST");
			break;
		case 4:
			film_name.setText("MOONLIGHT");
			break;
		case 5:
			film_name.setText("LA LA LAND");
			break;
		}
		film_name.setFont(font);
		p12.add(film_name, BorderLayout.NORTH);

		JLabel film_intro = new JLabel();
		film_intro = new JLabel("film intro", JLabel.CENTER);
		switch (choice) {
		case 1:
			film_intro.setText("<html> 180min<br> INTRO<br> The story of the film took place in 1970s, "
					+ "tells a story of a team of scientists, explorers, war photographers, military expedition, "
					+ "adventure in the Pacific Islands before the South Pacific story.</html>");
			break;
		case 2:
			film_intro.setText("<html>135min<br>INTRO <br> Based on the Marvel comics, the story is set in 2029, "
					+ "tells the story into old Wolverine gradually lost the healing factor in vivo, "
					+ "when a mutant with his abilities similar to Lara, "
					+ "Wolverine decided to the mountain to protect Lara's story</html>");
			break;
		case 3:
			film_intro.setText("<html>130min<br>INTRO <br> The film depicts a prince into the beast, "
					+ "and his father came to the castle to rescue the living girl Belle, they grew closer to live in, "
					+ "and finally successfully release the magic beast Belle life together in the story </html>");
			break;
		case 4:
			film_intro.setText(
					"<html>111min<br>INTRO <br> The film tells the story of the child from the child to the young, "
							+ "gradually found their sexual orientation, subjected to outside criticism and inner struggle, "
							+ "to find the true self story. </html>");
			break;
		case 5:
			film_intro.setText(
					"<html>128min<br>INTRO <br> The film tells a love story between a jazz pianist and an actress with a dream</html>");
			break;
		}

		film_intro.setFont(font1);
		p12.add(film_intro);

		// Add panel p2

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(250, 245, 255));
		p2.setLayout(new BorderLayout());
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));

		JLabel film_choice = new JLabel("Please choose screen and time:");
		film_choice.setFont(font);

		p2.add(film_choice, BorderLayout.NORTH);
		contentPane.add(p2, BorderLayout.CENTER);

		// Add panel p3
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(250, 245, 255));
		p3.setLayout(new GridLayout(2, 2));

		okButton = new JButton("OK!");
		okButton.setBackground(new Color(180, 190, 240));
		okButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		final Choice choice_1 = new Choice();
		choice_1.setBounds(161, 73, 97, 21);
		choice_1.setBackground(Color.WHITE);
		// initialize chocie_1
		switch (choice) {
		case 1:
			choice_1.addItem("Screen 1");
			choice_1.addItem("Screen 2");
			choice_1.addItem("Screen 3");
			break;
		case 2:
			choice_1.addItem("Screen 3");
			break;
		case 3:
			choice_1.addItem("Screen 1");
			choice_1.addItem("Screen 3");
			break;
		case 4:
			choice_1.addItem("Screen 2");
			break;
		case 5:
			choice_1.addItem("Screen 2");
			break;
		}
		p3.add(choice_1);

		final Choice choice_2 = new Choice();
		choice_2.setBounds(276, 73, 97, 21);
		choice_2.setBackground(Color.WHITE);
		String[] temp = null;
		// initialize choice_2
		switch (choice) {
		case 1:
			temp = findTime(choice, "Screen 1");
			break;
		case 2:
			temp = findTime(choice, "Screen 3");
			break;
		case 3:
			temp = findTime(choice, "Screen 1");
			break;
		case 4:
			temp = findTime(choice, "Screen 2");
			break;
		case 5:
			temp = findTime(choice, "Screen 2");
			break;
		}

		for (int i = 0; temp[i] != null; i++)
			if (isValidTime(temp[i]))
				choice_2.addItem(temp[i]);

		if (choice_2.getItemCount() == 0) {
			choice_2.addItem("UNAVLIABLE");
			choice_2.setEnabled(false);
			okButton.setEnabled(false);
		}
		p3.add(choice_2);

		choice_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				choice_2.removeAll();

				String[] temp = findTime(choice, choice_1.getSelectedItem());
				for (int i = 0; temp[i] != null; i++) {
					if (isValidTime(temp[i]))
						choice_2.addItem(temp[i]);
				}
				if (choice_2.getItemCount() == 0) {
					choice_2.addItem("Unavaliable");
					choice_2.setEnabled(false);
					okButton.setEnabled(false);
				}

			}
		});

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

				ticket.setMovie(film);
				DateFormat df = DateFormat.getDateInstance();
				ticket.setDate(df.format(new Date()));
				ticket.setScreen(choice_1.getSelectedItem());
				ticket.setTime(choice_2.getSelectedItem());

			}
		});
		okButton.setFont(new Font("Calibri", Font.PLAIN, 12));
		okButton.setBackground(new Color(180, 190, 240));
		okButton.setActionCommand("CONFIRM");
		okButton.setOpaque(true);

		cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(new Color(240, 190, 180));
		cancelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		cancelButton.setOpaque(true);

		p3.add(cancelButton, BorderLayout.SOUTH);
		p3.add(okButton, BorderLayout.SOUTH);

		contentPane.add(p3, BorderLayout.SOUTH);

		f.pack();
		f.setSize(800, 720);
		f.setVisible(true);

	}

	private boolean isValidTime(String time) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		int hour1 = Integer.parseInt(time.split(":")[0]);
		int minute1 = Integer.parseInt(time.split(":")[1]);
		if (hour > hour1)
			return false;
		if (hour == hour1 && minute > minute1)
			return false;
		return true;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public com.test.bean.Ticket getTicket() {
		return ticket;
	}

	public void setTicket(com.test.bean.Ticket ticket) {
		this.ticket = ticket;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

}
