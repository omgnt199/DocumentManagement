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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class xoasach extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xoasach frame = new xoasach();
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
	public xoasach() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("NHAP MA SACH MUON XOA");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText()==null))
				{
					try {

						String url = "jdbc:sqlserver://localhost:1433;databaseName=BOOK";// your db name
					    String user="admin"; // your db username
					    String password="123"; // your db password
					    Connection conn;
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						conn = DriverManager.getConnection(url, user, password);
						String ms=textField.getText();
						var sql = "select * from BOOK_INFO where IdB='"+ms+"'";
						var tt=conn.prepareStatement(sql);
						var result=tt.executeQuery();
						if(result.next()==false) {
							lblNewLabel_1.setText("Không có sách này trong thư viện");
						}
						else {
							var sql1="delete from BOOK_INFO where IdB='"+ms+"'";
							var tt1=conn.prepareCall(sql1);
							tt1.executeUpdate();
							lblNewLabel_1.setText("Xóa sách thành công");
						}
					}
					catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DocumentControl();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(265)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(274, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(726, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(26)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
