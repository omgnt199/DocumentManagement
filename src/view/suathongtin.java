package view;
import documentary.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class suathongtin extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdBrepair;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtName;
	private JTextField txtAuthor;
	private JTextField txtYear;
	private JTextField txtAmount;
	private JTextField txtIdB;
	private JTextField txtType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					suathongtin frame = new suathongtin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public suathongtin() {
		setVisible(true);
		setTitle("SUA THONG TIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 506);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp m\u00E3 s\u00E1ch mu\u1ED1n s\u1EEDa");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		

		txtIdBrepair = new JTextField();

		txtIdBrepair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdBrepair.setColumns(10);


		
		
		lblNewLabel_1 = new JLabel("Th\u00F4ng tin s\u00E1ch mu\u1ED1n s\u1EEDa");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_2 = new JLabel("Document Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_3 = new JLabel("Author");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_4 = new JLabel("Year");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_6 = new JLabel("IdB");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_7 = new JLabel("Type");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);

		
		txtAuthor = new JTextField();
		txtAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAuthor.setColumns(10);

		
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtYear.setColumns(10);

		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmount.setColumns(10);

		
		txtIdB = new JTextField();
		txtIdB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdB.setColumns(10);

		
		txtType = new JTextField();
		txtType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtType.setColumns(10);

		JButton btnNewButton = new JButton("OK");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					    String url = "jdbc:sqlserver://localhost:1433;databaseName=ManageDocument";// your db name
					    String user="admin"; // your db username
					    String password="123"; // your db password
					    Connection conn;
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						conn = DriverManager.getConnection(url, user, password);
						String masach = txtIdBrepair.getText();
						String sql = "select * from BOOK_INFO where IdB='"+masach+"'";
						var thongtin = conn.prepareStatement(sql);
						var result = thongtin.executeQuery();

						while(result.next())
						{
							txtName.setText(result.getString("DocumentName"));
							txtAuthor.setText(result.getString("Author"));
							txtYear.setText(String.valueOf(result.getInt("Year")));
							txtAmount.setText(String.valueOf(result.getInt("Amount")));
							txtIdB.setText(result.getString("IdB"));
							txtType.setText(result.getString("Type"));
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				
				
				
			}
		});

		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    String url = "jdbc:sqlserver://localhost:1433;databaseName=ManageDocument";// your db name
				    String user="admin"; // your db username
				    String password="123"; // your db password
				    Connection conn;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url, user, password);
					String documentname = txtName.getText();
					String auhtor = txtAuthor.getText();
					String year = txtYear.getText();
					String amount = txtAmount.getText();
					String idb = txtIdBrepair.getText();
					String type  = txtType.getText();
					
					var sql = "update BOOK_INFO set DocumentName='"+documentname+"',Author='"+auhtor+"',Year="+year+",Amount="+amount+",Type='"
							+type+"'where IdB='"+idb+"'";
					var suatt = conn.prepareStatement(sql);
					suatt.executeUpdate();		
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DocumentControl();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtType, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtIdB, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(221)
							.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(txtIdBrepair, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(btnNewButton))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(221)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(221)
							.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(221)
							.addComponent(txtYear, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(137, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(197)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(62))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdBrepair, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addComponent(lblNewLabel_1))
						.addComponent(btnNewButton))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(lblNewLabel_2)
							.addGap(28)
							.addComponent(lblNewLabel_3)
							.addGap(21)
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(txtYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtIdB, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(txtType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {txtIdB, txtAmount});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtName, txtAuthor, txtYear});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtIdB, txtType, txtAmount});
		contentPane.setLayout(gl_contentPane);

	}
}
