package file;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Mess extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public void go() {
		setVisible(true);
		setAlwaysOnTop(true);
		Date date1 = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date1);

		/*
		 * Calendar cal = Calendar.getInstance(); cal.setTime(date1);
		 * cal.add(Calendar.DATE, -1); String time1 =
		 * format.format(cal.getTime());
		 */

		setTitle(time);
		setBounds(100, 100, 456, 259);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 243, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel MessageLabel = new JLabel();
		MessageLabel.setBackground(new Color(213, 243, 245));
		MessageLabel.setFont(new Font("Arial", Font.BOLD, 30));
		MessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MessageLabel.setBounds(91, 49, 269, 44);
		contentPane.add(MessageLabel);

		String file = time.concat(".txt");
		// String file1 = time1.concat(".txt");

		File f = new File(file);
		// File f1 = new File(file1);

		if (f.exists()) {
			MessageLabel.setText("Email sent!");
		} else {
			MessageLabel.setText("Failed to send!");
		}

		JButton Confirm = new JButton("Confirm");
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		Confirm.setFont(new Font("Arial", Font.BOLD, 25));
		Confirm.setOpaque(true);
		Confirm.setBackground(new Color(180, 240, 190));
		Confirm.setBounds(140, 125, 158, 44);
		contentPane.add(Confirm);
	}
}
