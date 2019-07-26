package com.test.seat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.test.bean.Ticket;

import file.Time;
import filmSystem.FilmInfo;
import ticket.Payment;
import ticket.Thank;

public class Welcome extends JFrame {
	public MainBoard mainBoard;
	public Ticket ticket;

	public FilmInfo filmInfo;

	public JFrame mainFrame;

	public FilmDetail filmDetail;

	private JPanel contentPane;

	private JFrame ticekt_2_Frame;
	private ticket.Ticket ticket_2;
	private Payment payment;
	private Thank thank;

	/**
	 * Launch the application.
	 * the constructor of Welcome, the page which display some info of the entrance.
	 */

	public Welcome() {
		new Time();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 245, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(Box.createVerticalGlue());
		this.setResizable(false);
		this.setLocation(150, 90);

		JPanel lblPanel = new JPanel();
		lblPanel.setBackground(null);
		lblPanel.setMaximumSize(new Dimension(800, 200));
		JLabel lblNewLabel = new JLabel(
				"<html><p style='text-align:center;font-family:arial;font-size:32px;font-weight:bold;'>WELCOME TO"
						+ "<br>SELF-SERVICE TICKETING KIOSK."
						+ "<br><b style='font-size:18px'>May I Help You?</b></p></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel.add(lblNewLabel);
		contentPane.add(lblPanel);
		contentPane.add(Box.createRigidArea(new Dimension(0, 45)));

		JButton btnNewButton = new JButton(
				"<html><p style='font-size:21px;font-family:arial;'>YES, LET'S BEGIN</p></html>");
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ticket = new Ticket();

				filmDetail = new FilmDetail();
				filmDetail.setPreferredSize(new Dimension(720, 1500));

				JScrollPane scrollPane = new JScrollPane(null);
				scrollPane.getVerticalScrollBar().setUnitIncrement(10);
				scrollPane.setViewportView(filmDetail);

				mainFrame = new JFrame();
				mainFrame.add(scrollPane);
				mainFrame.setSize(800, 720);
				mainFrame.setResizable(false);
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.setLocation(150, 90);

				mainFrame.setVisible(true);

				filmDetail.getOkButton().addMouseListener(new MouseListener() {

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
						startDetailBoard(filmDetail.getMovieName());
						mainFrame.setVisible(false);
					}

					public void startDetailBoard(int movieNo) {
						filmInfo = new FilmInfo(movieNo);

						filmInfo.getOkButton().addMouseListener(new MouseListener() {

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
								if (!filmDetail.getSelect().getText().equals(FilmDetail.ORIGIN_WORDS)) {
									ticket = filmInfo.getTicket();
									mainBoard = StartMainBoard(ticket);
									mainBoard.setVisible(true);
								} else
									filmDetail.setVisible(true);
							}
						});

						filmInfo.getCancelButton().addMouseListener(new MouseListener() {

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
								filmInfo.setVisible(false);
								mainFrame.setVisible(true);
							}
						});

					}

					private MainBoard StartMainBoard(Ticket ticket) {
						// TODO Auto-generated method stub
						final MainBoard mainBoard = new MainBoard(ticket);
						ticket_2 = new ticket.Ticket();

						mainBoard.getSubmitButton().addMouseListener(new MouseListener() {

							@Override
							public void mouseReleased(MouseEvent arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mousePressed(MouseEvent arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseExited(MouseEvent arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseEntered(MouseEvent arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseClicked(MouseEvent arg0) {
								// TODO Auto-generated method stub
								ticekt_2_Frame = null;
								if (mainBoard.getTicketList().size() > 0) {
									ticekt_2_Frame = ticket_2.showTIcketSelectPanel(mainBoard.getTicketList());
									mainBoard.setVisible(false);
									ticekt_2_Frame.setVisible(true);
									setListenerOfT2();
								}
							}

						});

						mainBoard.getCancelButton().addMouseListener(new MouseListener() {

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
								mainBoard.setVisible(false);
								filmInfo.setVisible(true);
							}
						});

						return mainBoard;
					}

				});

			}
		});

		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(null);
		btnPanel.setMaximumSize(new Dimension(800, 200));

		btnNewButton.setBackground(new Color(190, 180, 240));
		btnNewButton.setPreferredSize(new Dimension(270, 50));
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setFocusPainted(false);

		btnPanel.add(btnNewButton);
		contentPane.add(btnPanel);
		contentPane.add(Box.createVerticalGlue());

		this.setVisible(true);

	}

	public void setListenerOfT2() {
		// System.out.println("COME T!!!");
		ticket_2.getNext().addMouseListener(new MouseListener() {

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
				ticekt_2_Frame.setVisible(false);
				payment = new Payment();
				payment.setVisible(true);
				System.out.println("GO PAY!!!");
				setListenerOfPayment();
			}

		});
	}

	private void setListenerOfPayment() {
		// TODO Auto-generated method stub
		payment.getCancel().addMouseListener(new MouseListener() {

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
				payment.setVisible(false);
				mainBoard.setVisible(true);
			}
		});

		payment.getFinish().addMouseListener(new MouseListener() {

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
				thank = new Thank();
				thank.setVisible(true);
				setListenerOfThank();
			}
		});
	}

	protected void setListenerOfThank() {
		// TODO Auto-generated method stub
		thank.getBtnContinue().addMouseListener(new MouseListener() {

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
				thank.setVisible(false);
				setVisible(true);
			}
		});
	}

}
