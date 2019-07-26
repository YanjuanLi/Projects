package ticket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Payment extends JFrame {

	JLabel totall;
	private JButton cancel;
	private JButton finish;

	public JLabel getTotall() {
		return totall;
	}

	public void setTotall(JLabel totall) {
		this.totall = totall;
	}

	public Payment() {

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

		getContentPane().setBackground(new Color(250, 245, 255));
		setSize(800, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setLocation(150, 90);
		this.setResizable(false);

		JLabel total = new JLabel("Total:");
		total.setFont(new Font("Arial", Font.BOLD, 25));
		total.setBounds(200, 200, 100, 19);
		getContentPane().add(total);

		JLabel totall = new JLabel();
		totall.setFont(new Font("Arial", Font.PLAIN, 20));
		totall.setBounds(300, 200, 100, 16);
		getContentPane().add(totall);

		JLabel please = new JLabel("Please choose a payment method:");
		please.setFont(new Font("Arial", Font.BOLD, 25));
		please.setBounds(200, 255, 400, 30);
		getContentPane().add(please);

		JRadioButton cash = new JRadioButton("Cash");
		cash.setBackground(null);
		cash.setFont(new Font("Arial", Font.BOLD, 20));
		cash.setFocusPainted(false);
		cash.setBounds(230, 320, 88, 23);
		getContentPane().add(cash);

		JRadioButton bank = new JRadioButton("Bank Card");
		bank.setBackground(null);
		bank.setFont(new Font("Arial", Font.BOLD, 20));
		bank.setFocusPainted(false);
		bank.setBounds(350, 320, 141, 23);
		getContentPane().add(bank);

		finish = new JButton("Finish");
		finish.setOpaque(true);
		finish.setBackground(new Color(180, 240, 190));
		finish.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);

				String line2;
				ArrayList<String> list2 = new ArrayList<String>();

				try {
					BufferedReader reader = new BufferedReader(new FileReader("./ticket.txt"));
					while ((line2 = reader.readLine()) != null) {
						list2.add(line2);
					}

					File dir = new File("./tickets");
					if (!dir.exists()) {
						try {
							dir.mkdirs();
						} catch (Exception e4) {
							e4.printStackTrace();
						}
					}
					for (int i = 0; i < list2.size(); i = i + 8) {
						String content = list2.get(i);
						String content2 = list2.get(i + 1);
						if (content2.contains(" ")) {
							String arr[] = content2.split(" ");
							content2 = "";
							for (int j = 0; j < arr.length; j++) {
								if (j == 0) {
									content2 = arr[0];
								} else {
									content2 = content2 + "_" + arr[j];
								}
							}
							System.out.println(content2);
						}
						String content3 = list2.get(i + 2);
						String content4 = list2.get(i + 3);
						String content5 = list2.get(i + 4);
						String content6 = list2.get(i + 5);
						String content7 = list2.get(i + 6);
						String content8 = list2.get(i + 7);
						String accountNo = (list2.get(i + 4)).substring(10);

						File file = new File("tickets/ticket_" + accountNo + ".txt");
						if (!file.exists())
							try {
								file.createNewFile();
							} catch (Exception e3) {
								System.out.println("Create fail");
							}

						try {
							FileOutputStream out = new FileOutputStream(file);
							PrintStream p = new PrintStream(out);
							p.println(content);
							p.println(content2);
							p.println(content3);
							p.println(content4);
							p.println(content5);
							p.println(content6);
							p.println(content7);
							p.println(content8);
							p.close();
							out.close();

						} catch (Exception e5) {
							System.out.println("Write fail");
						}

					}

					reader.close();
				} catch (Exception e2) {

				}

				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("./ticket.txt"));
					writer.write("");
					writer.close();

				} catch (Exception a1) {
					System.out.println("Finish fail");
				}
			}
		});
		finish.setBounds(450, 400, 117, 29);
		getContentPane().add(finish);

		cancel = new JButton("Cancel");
		cancel.setOpaque(true);
		cancel.setBackground(new Color(240, 190, 180));
		cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("./ticket.txt"));
					writer.write("");
					writer.close();

				} catch (Exception a1) {
					System.out.println("Cancel fail");
				}

			}
		});
		cancel.setBounds(200, 400, 117, 29);
		getContentPane().add(cancel);

		String pay;
		double pay1;
		double sum = 0;
		String line;
		ArrayList<String> list = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./ticket.txt"));
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}

			int a = (list.size()) / 8;
			for (int j = 0; j < a; j++) {

				pay = list.get(5 + 8 * j).substring(6);
				pay1 = Double.parseDouble(pay);
				sum = sum + pay1;

			}
			totall.setText(String.valueOf((double) Math.round(sum * 100) / 100));

			reader.close();
		} catch (Exception e) {
			System.out.println("Read price error");
		}

	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JButton getFinish() {
		return finish;
	}

	public void setFinish(JButton finish) {
		this.finish = finish;
	}

}
