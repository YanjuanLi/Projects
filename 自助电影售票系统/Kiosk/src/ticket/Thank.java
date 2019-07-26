package ticket;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import file.Read;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thank extends JFrame {
	private JButton con;

	public Thank() {

		setSize(800, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(250, 245, 255));
		this.setResizable(false);
		this.setLocation(150, 90);

		JLabel lblPaySuccess = new JLabel("Payment Successful");
		lblPaySuccess.setFont(new Font("Arial", Font.BOLD, 25));
		lblPaySuccess.setBounds(200, 230, 400, 30);
		getContentPane().add(lblPaySuccess);

		JLabel lblThankYouFor = new JLabel("Thank You For Your Consumption!");
		lblThankYouFor.setFont(new Font("Arial", Font.BOLD, 25));
		lblThankYouFor.setBounds(150, 330, 500, 30);
		getContentPane().add(lblThankYouFor);

		con = new JButton("Continue".toUpperCase());
		con.setOpaque(true);
		con.setBackground(new Color(180, 190, 240));
		con.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		con.setBounds(470, 430, 125, 30);
		getContentPane().add(con);

		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Read a = new Read();
				a.getFile();

			}
		});

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
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
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	public JButton getBtnContinue() {
		return con;
	}

	public void setBtnContinue(JButton con) {
		this.con = con;
	}

}
