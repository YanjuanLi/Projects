package com.test.seat;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import filmSystem.FilmInfo;
import filmSystem.Get;

public class FilmDetail extends JPanel implements ActionListener {

	public static int SelectFilm;
	JButton[] film = new JButton[20];
	private JLabel Select;
	JButton okButton;
	int movieName;
	public static final String ORIGIN_WORDS = "<html>SELECT THE FILM <br>YOU WANT TO WATCH.</html>";

	// the constructor of FilmDetail, the page which display few movies on the
	// screen.
	public FilmDetail() {
		this.setLayout(null);
		this.setBackground(new Color(250, 245, 255));
		Get G = new Get();
		String[] x = G.line;
		int q = x.length - 1;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		p1.setLayout(new GridLayout(q / 2, 1));
		p2.setLayout(new GridLayout(q / 2, 1));
		p3.setLayout(new GridLayout(q / 2, 1));
		p4.setLayout(new GridLayout(1 / 2, 1));
		p5.setLayout(new GridLayout(1, 1));
		Select = new JLabel(ORIGIN_WORDS);
		Select.setFont(new Font("Arial", Font.BOLD, 25));
		okButton = new JButton("CONFIRM");

		okButton.setFont(new Font("Arial", Font.BOLD, 30));
		okButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		okButton.setFocusPainted(false);

		p1.setBounds(new Rectangle(20, 200, 150, 1300));
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.add(p1);

		p2.setBounds(new Rectangle(200, 200, 300, 1300));
		p2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.add(p2);

		p3.setBounds(new Rectangle(515, 200, 150, 1300));
		p3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.add(p3);

		p4.setBounds(new Rectangle(20, 30, 500, 90));

		p4.add(Select);
		this.add(p4);

		okButton.setOpaque(true);
		okButton.setBackground(new Color(180, 190, 250));
		okButton.addActionListener(this);

		p5.setBounds(new Rectangle(535, 20, 180, 60));
		p5.add(okButton);
		this.add(p5);

		okButton.addActionListener(this);

		p1.setBackground(new Color(250, 245, 255));
		p2.setBackground(new Color(250, 245, 255));
		p3.setBackground(new Color(250, 245, 255));
		p4.setBackground(new Color(250, 245, 255));
		p4.setBackground(new Color(250, 245, 255));

		okButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new FilmInfo(movieName - 5);

			}
		});

		for (int a = 0; a < q / 2; a = a + 1) {
			ImageIcon image = new ImageIcon(x[2 * a] + ".jpg");
			JLabel l2 = new JLabel(image);
			p1.add(l2);
		}

		for (int b = 0; b < q / 2; b = b + 1) {
			JButton y = new JButton(x[2 * b]);
			film[b] = y;
			film[b].addActionListener(this);
			film[b].setFont(new Font("Arial", Font.BOLD, 22));
			film[b].setBackground(Color.WHITE);
			p2.add(film[b]);
		}

		for (int c = 0; c < q / 2; c = c + 1) {
			JLabel l3 = new JLabel(x[2 * c + 1], JLabel.CENTER);
			l3.setFont(new Font("Arial", Font.BOLD, 25));
			p3.add(l3);
		}

	}

	public void actionPerformed(ActionEvent e) {
		Get G = new Get();
		String[] x = G.line;
		int q = x.length - 1;
		for (int b = 0; b < q / 2; b = b + 1) {
			if (e.getSource() == film[b]) {
				SelectFilm = b;
				Select.setText("YOU SELECTED:  " + x[2 * b]);
				movieName = b + 1;
			}
		}
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public int getMovieName() {
		return movieName;
	}

	public void setMovieName(int movieName) {
		this.movieName = movieName;
	}

	public JLabel getSelect() {
		return Select;
	}

	public void setSelect(JLabel select) {
		Select = select;
	}

}
