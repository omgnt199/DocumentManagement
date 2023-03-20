package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class DocumentControl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentControl frame = new DocumentControl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DocumentControl() {

		setVisible(true);
		setTitle("DocumentControl");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("CH\u1EE8C N\u0102NG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("TH\u00CAM S\u00C1CH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new themsach_view();
				
			}
		});

		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("S\u1EECA TH\u00D4NG TIN");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new suathongtin();
			}
			});

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("X\u00D3A S\u00C1CH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new xoasach();
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("T\u00CCM KI\u1EBEM");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new timkiem();
				} catch (ClassNotFoundException | NullPointerException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_4 = new JButton("EXIT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MENU_LIBRARY();
			}
		});
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_5 = new JButton("SÁCH THƯ VIỆN");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new sach();
				} catch (NullPointerException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2)
								.addComponent(btnNewButton_3)
								.addComponent(btnNewButton_4)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(btnNewButton_5)))
					.addContainerGap(424, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnNewButton_5)
					.addGap(23)
					.addComponent(btnNewButton)
					.addGap(24)
					.addComponent(btnNewButton_1)
					.addGap(30)
					.addComponent(btnNewButton_2)
					.addGap(30)
					.addComponent(btnNewButton_3)
					.addGap(34)
					.addComponent(btnNewButton_4)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
