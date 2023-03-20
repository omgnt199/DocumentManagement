package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;

public class readerControl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					readerControl frame = new readerControl();
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
	public readerControl() {
		setVisible(true);

		setTitle("Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("CHỨC NĂNG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("DANH SÁCH BẠN ĐỌC");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("THÊM BẠN ĐỌC");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("SỬA THÔNG TIN BẠN ĐỌC");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("XÓA THÔNG TIN BẠN ĐỌC");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_4 = new JButton("TÌM KIẾM THÔNG TIN BẠN ĐỌC");
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_5 = new JButton("EXIT");
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5))
					.addContainerGap(733, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addGap(34)
					.addComponent(btnNewButton)
					.addGap(47)
					.addComponent(btnNewButton_1)
					.addGap(48)
					.addComponent(btnNewButton_2)
					.addGap(58)
					.addComponent(btnNewButton_3)
					.addGap(54)
					.addComponent(btnNewButton_4)
					.addGap(45)
					.addComponent(btnNewButton_5)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {lblNewLabel, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4, btnNewButton_5});
		contentPane.setLayout(gl_contentPane);
	}
}
