package view;
import documentary.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.Date;
public class ManageReader extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton prevButton;
	private JButton nextButton;
	private JButton firstButton;
	private JTextField pIDtxt;
	private JTextField fullnametxt;
	private JTextField addresstxt;
	private JTextField agetxt;
	private JTextField idreadertxt;
	private JTextField phonenumbertxt;
	private JTextField emailtxt;
	private JComboBox comboBox;
	private ConnectSQL con;
	private DefaultTableModel model;
	private ArrayList<Reader> list = new ArrayList<>();
	private JButton lastButton;
	private Integer totalpage = 1;
	private Integer totalvalue = 0 ;
	private Integer valueperpage = 5;
	private Integer page = 1;
	private JLabel pagelabel;
	private JLabel totalpagelabel;
	private JComboBox typereadercombobox;
	private JButton btnNewButton_2;
	private JTextField searchtxt;
	private JButton btnNewButton_3;
	private JComboBox sexcombo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageReader frame = new ManageReader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void ReaderLib() throws ClassNotFoundException, NullPointerException, SQLException {
		setVisible(true);
		con = new ConnectSQL();
		try {
			var sql ="select * from READER_INFO";
			var statement = con.conn.prepareStatement(sql);
			var result = statement.executeQuery();
			while(result.next()) {
				Reader r = new Reader();
				r.setpID(result.getString("pID"));
				r.setFullname(result.getString("fullname"));
				r.setAddress(result.getString("address"));
				r.setAge(result.getDate("age"));
				r.setSex(result.getString("sex"));
				r.setIdReader(result.getString("idReader"));
				r.setTypeReader(result.getString("typeReader"));
				r.setPhonenumber(result.getString("phonenumber"));
				r.setEmail(result.getString("email"));
				list.add(r);
			}
		}
		
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws NullPointerException 
	 * @throws ClassNotFoundException 
	 */
	public ManageReader() throws ClassNotFoundException, NullPointerException, SQLException {
		ReaderLib();
		setTitle("ManageReader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		lastButton = new JButton("Last");
		lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = totalpage;
				initPagination();
			}
		});
		lastButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 comboBox = new JComboBox();
		 comboBox.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		initPagination();
		 	}
		 });
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 prevButton = new JButton("Prev");
		 prevButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(page>1) {
		 			page--;
		 			initPagination();
		 		}
		 	}
		 });
		prevButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 nextButton = new JButton("Next");
		 nextButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(page<totalpage) {
		 			page++;
		 			initPagination();
		 		}
		 	}
		 });
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 firstButton = new JButton("First\r\n");
		 firstButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		page = 1;
		 		initPagination();
		 	}
		 });
		firstButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pagelabel = new JLabel("Page 1 for 1");
		pagelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		totalpagelabel = new JLabel("TotalPage:1");
		totalpagelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox searchcombobox = new JComboBox();
		searchcombobox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchcombobox.setModel(new DefaultComboBoxModel(new String[] {"fullname", "idReader", "typeReader"}));
		
		searchtxt = new JTextField();
		searchtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchtxt.setColumns(10);
		
		JButton searchbutton = new JButton("Search");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				try {
						String s1 = (String)searchcombobox.getItemAt(searchcombobox.getSelectedIndex());
						String s2 = searchtxt.getText();

						var sql = "select * from READER_INFO where "+s1 +" like '"+"%"+s2+"%'";
						var statement = con.conn.prepareStatement(sql);
						var result = statement.executeQuery();
						while(result.next()) {
							Reader r = new Reader();
							r.setpID(result.getString("pID"));
							r.setFullname(result.getString("fullname"));
							r.setAddress(result.getString("address"));
							r.setAge(result.getDate("age"));
							r.setSex(result.getString("sex"));
							r.setIdReader(result.getString("idReader"));
							r.setTypeReader(result.getString("typeReader"));
							r.setPhonenumber(result.getString("phonenumber"));
							r.setEmail(result.getString("email"));
							model.addRow(new Object[] {
									r.getpID(),r.getFullname(),r.getAddress(),r.getAge(),r.getSex(),r.getIdReader(),r.getTypeReader(),r.getPhonenumber(),r.getEmail()
							 });
						}
						
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		searchbutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MENU_LIBRARY();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(pagelabel)
							.addGap(489)
							.addComponent(totalpagelabel)
							.addGap(68)
							.addComponent(btnNewButton_3)
							.addContainerGap(18, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(searchcombobox, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(searchtxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(searchbutton)
									.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
									.addComponent(lastButton)
									.addGap(33)
									.addComponent(prevButton)
									.addGap(33)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(nextButton)
									.addGap(18)
									.addComponent(firstButton)
									.addGap(38))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lastButton)
									.addComponent(searchcombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(searchtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(searchbutton))
								.addComponent(prevButton)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nextButton)
								.addComponent(firstButton))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pagelabel)
								.addComponent(totalpagelabel)
								.addComponent(btnNewButton_3))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				System.out.println(Date.valueOf(agetxt.getText()));
				try {
				Reader r =new Reader();
				r.setpID(pIDtxt.getText());
				r.setFullname(fullnametxt.getText());
				r.setAddress(addresstxt.getText());
				r.setAge(Date.valueOf(agetxt.getText()));
				r.setSex((String)sexcombo.getItemAt(sexcombo.getSelectedIndex()));
				r.setIdReader(idreadertxt.getText());
				r.setTypeReader((String) typereadercombobox.getItemAt(typereadercombobox.getSelectedIndex()));
				r.setPhonenumber(phonenumbertxt.getText());
				r.setEmail(emailtxt.getText());


					var sql = "insert into READER_INFO VALUES('"+r.getpID()+"','"+r.getFullname()+"','"+r.getAddress()+"','"+r.getSex()+"','"+r.getIdReader()+"','"+
								r.getTypeReader()+"','"+r.getPhonenumber()+"','"+r.getEmail()+"','"+r.getAge()+"')";
					var statement = con.conn.prepareStatement(sql);
					statement.executeUpdate();
				}
				 catch (SQLException e1) {
					e1.printStackTrace();
				 }
				catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				}
				try {
					ReaderLib();

				} catch (ClassNotFoundException | NullPointerException | SQLException e1) {
					e1.printStackTrace();
				}
				initPagination();
			}
		
		});
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("PiD");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("FullName");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_5 = new JLabel("IdReader");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_6 = new JLabel("TypeReader");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_7 = new JLabel("PhoneNumber");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		pIDtxt = new JTextField();
		pIDtxt.setToolTipText("");
		pIDtxt.setColumns(10);
		
		fullnametxt = new JTextField();
		fullnametxt.setColumns(10);
		
		addresstxt = new JTextField();
		addresstxt.setColumns(10);
		
		agetxt = new JTextField();
		agetxt.setColumns(10);
		
		idreadertxt = new JTextField();
		idreadertxt.setColumns(10);
		idreadertxt.setText("BD_");
		
		phonenumbertxt = new JTextField();
		phonenumbertxt.setColumns(10);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		
		typereadercombobox = new JComboBox();
		typereadercombobox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		typereadercombobox.setModel(new DefaultComboBoxModel(new String[] {"Hoc SInh", "Sinh Vien", "Giao Vien", "Nha Van", "Nha Bao", "Nguoi Gia"}));
		
		btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pIDtxt.setText(" ");
				addresstxt.setText(" ");
				fullnametxt.setText(" ");
				agetxt.setText(" ");
				idreadertxt.setText(" ");
				phonenumbertxt.setText(" ");
				emailtxt.setText(" ");
			}
		});
		
		 sexcombo = new JComboBox();
		sexcombo.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(addresstxt, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(agetxt, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(sexcombo, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idreadertxt, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(typereadercombobox, 0, 155, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phonenumbertxt, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(emailtxt, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)
							.addGap(26)
							.addComponent(btnNewButton_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pIDtxt, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fullnametxt)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(pIDtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(fullnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(addresstxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(agetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(sexcombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(idreadertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(typereadercombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(phonenumbertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(emailtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8});
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"pID", "fullname", "address", "age", "sex", "idReader", "typeReader", "phonenumber", "email"
			}
		));
		model=(DefaultTableModel) table.getModel();

		initPagination();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	void initPagination() {
		 model.setRowCount(0);
		 totalvalue = list.size();
		 valueperpage = Integer.parseInt((String) comboBox.getItemAt(comboBox.getSelectedIndex()));

		 Double totalpageD = Math.ceil(totalvalue.doubleValue()/valueperpage.doubleValue());
		 totalpage = totalpageD.intValue();
		 pagelabel.setText("TotalPage:"+totalpage);
		 totalpagelabel.setText("Page "+page+" for "+totalpage);
		 if(page.equals(1)) {
			 firstButton.setEnabled(false);
			 prevButton.setEnabled(false);
		 }
		 else {
			 firstButton.setEnabled(true);
			 prevButton.setEnabled(true);
		 }
		 if(page.equals(totalpage)) {
			 lastButton.setEnabled(false);
			 nextButton.setEnabled(false);
		 }
		 else {
			 lastButton.setEnabled(true);
			 nextButton.setEnabled(true);
		 }
		 if(page>totalpage) {
			 page = 1;
		 }
		 int n = valueperpage*page;
		 if(n>totalvalue) n=totalvalue;
		 for(int i=valueperpage*(page-1);i<n;i++) {
			 Reader r = new Reader();
			 r  = list.get(i);
			 model.addRow(new Object[] {
					r.getpID(),r.getFullname(),r.getAddress(),r.getAge(),r.getSex(),r.getIdReader(),r.getTypeReader(),r.getPhonenumber(),r.getEmail()
			 });
		 }
	}
}



