package com.test.seat;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SingleSeat extends JPanel {

	private final static Color AVAILABLE = new Color(120, 150, 240);
	private final static Color UNAVAILABLE = new Color(140, 250, 130);
	private final static Color SELECTED = new Color(240, 150, 120);
	public static final Color[] STATE_COLORS = { Color.BLACK, AVAILABLE, SELECTED, UNAVAILABLE };
	private final Color BACKGROUND = new Color(255, 255, 255);

	private int state = 0;
	private String position;

	private JButton chair;

	
	/**
	 * the constructor of SingleSeat which display the image of a single seat.
	 */
	public SingleSeat() {

		this.setPreferredSize(new Dimension(75, 70));
		this.setBackground(null);

		chair = new JButton();
		Dimension chairSize = new Dimension(40, 60);
		chair.setPreferredSize(chairSize);
		chair.setFocusPainted(false);
		chair.setBorder(null);
		chair.setMargin(new Insets(0, 0, 0, 0));
		chair.setBackground(STATE_COLORS[state]);
		chair.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		this.add(chair);

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(BACKGROUND);
		g.fillRect((getWidth() - 60) / 2, (getHeight() - 40) / 2, 60, 45);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawRect((getWidth() - 60) / 2, (getHeight() - 40) / 2, 60, 45);
		g2d.setColor(STATE_COLORS[state]);
		g2d.fillRect((getWidth() - 40) / 2, (getHeight() - 60) / 2, 40, 60);

		g2d.setColor(Color.BLACK);
		g2d.drawRect((getWidth() - 40) / 2, (getHeight() - 60) / 2, 40, 60);
		Font font = new Font("Arial", Font.PLAIN, 18);
		g2d.setFont(font);
		g2d.drawString(position, (getWidth() - 20) / 2, (getHeight() + 14) / 2);

	}

	public JButton getChair() {
		return chair;
	}

	public void setChair(JButton chair) {
		this.chair = chair;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
