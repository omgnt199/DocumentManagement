package view;
import documentary.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import documentary.ConnectSQL;


import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class phieumuon_view extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField masachtxt;
	private JTextField tacgiatxt;
	private JTextField tensachtxt;
	private JTextField soluongtxt;
	private JDateChooser dateChooser;
	private JTextField fullnametxt;
	private JTextField phonenumbertxt;
	private DefaultTableModel model;
	private ConnectSQL con;
	private Book b;
	private JLabel  lblNewLabel_11;
	private DefaultComboBoxModel<String> combomodel;
	private ArrayList<String> listidReader;
	private PhieuMuon phieumuon;
	private JTextField tiendatcoctxt;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws NullPointerException 
	 * @throws ClassNotFoundException 
	 */
	void readerList() throws ClassNotFoundException, NullPointerException, SQLException {
		listidReader = new ArrayList<>();
		con = new ConnectSQL();
		var sql = "select idReader from READER_INFO";
		var statement = con.conn.prepareStatement(sql);
		var result = statement.executeQuery();
		while(result.next()) {
			listidReader.add((String) result.getString("idReader"));
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phieumuon_view frame = new phieumuon_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws NullPointerException 
	 * @throws ClassNotFoundException 
	 */
	public phieumuon_view() throws ClassNotFoundException, NullPointerException, SQLException {
		readerList();
		con = new ConnectSQL();
		setVisible(true);
		setTitle("Phiếu mượn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 599);
		contentPane = new JPanel();

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(50, 205, 50));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_4 = new JLabel("Danh sách mượn");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch","Số lượng"
			}
		));
		model =(DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Mã sách");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Tác Giả");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Tên Sách");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		masachtxt = new JTextField();
		masachtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		masachtxt.setColumns(10);
		masachtxt.setText("DCMT_");
		
		tacgiatxt = new JTextField();
		tacgiatxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tacgiatxt.setColumns(10);
		
		tensachtxt = new JTextField();
		tensachtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tensachtxt.setColumns(10);
		
		soluongtxt = new JTextField();
		soluongtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		soluongtxt.setColumns(10);
		
		JButton thembutton = new JButton("Thêm");
		thembutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(soluongtxt.getText())>5) {
						lblNewLabel_11.setText("Số lượng sách mượn không quá 5 quyển");;
				}
				else {
					if(tensachtxt.getText()!=null&&masachtxt.getText()!=null)
					{
					model.addRow(new Object[] {
							tensachtxt.getText(),masachtxt.getText(),soluongtxt.getText()
					});
					}
				
				}
			}
			
		});
		thembutton.setForeground(Color.GREEN);
		thembutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton xoabutton = new JButton("Xóa");
		xoabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		xoabutton.setForeground(Color.RED);
		xoabutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String id = masachtxt.getText();
				var sql = "select * from BOOK_INFO where IdB = '"+id+"'";
				var statement = con.conn.prepareStatement(sql);
				var result  = statement.executeQuery();
				 b = new Book();
				while(result.next()) {
					b.setDocumentName(result.getString("DocumentName"));
					b.setAuthor(result.getString("Author"));
				}
				tacgiatxt.setText(b.getAuthor());
				tensachtxt.setText(b.getDocumentName());
				if(b.getDocumentName()!=null && b.getIdB()!=null)
				{
				model.addRow(new Object[] {
						b.getIdB(),b.getDocumentName()
				});
				}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		searchButton.setForeground(Color.YELLOW);
		
		JLabel lblNewLabel_6 = new JLabel("Thêm sách mượn");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setForeground(Color.RED);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tacgiatxt, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(masachtxt, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchButton)))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(soluongtxt)
										.addComponent(tensachtxt, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(thembutton)
										.addComponent(xoabutton)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6)
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(masachtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tensachtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(thembutton)
						.addComponent(searchButton))
					.addGap(81)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3)
						.addComponent(tacgiatxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(soluongtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(xoabutton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Thông tin phiếu mượn");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_7 = new JLabel("Mã người đọc");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_8 = new JLabel("Tên người đọc");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_9 = new JLabel("Số điện thoại");
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_10 = new JLabel("Hạn trả");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton luuButton = new JButton("Lưu Phiếu");
		luuButton.setForeground(Color.BLUE);
		luuButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		luuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PhieuMuon p = new PhieuMuon();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String hantra  =  sdf.format(dateChooser.getDate());
					String ngaymuon = sdf.format(new Date());
					String idPhieumuon=" ";
					p.setIdPhieumuon(idPhieumuon);
					p.setidReader((String) comboBox.getItemAt(comboBox.getSelectedIndex()));
					p.setFullname(fullnametxt.getText());
					p.setNgaymuon(ngaymuon);
					p.setThoihanmuon(hantra);
					p.setSoluong((Integer.valueOf(tiendatcoctxt.getText())/5000));
					p.setTiencoc(Integer.valueOf(tiendatcoctxt.getText()));
					try {
					var sql = "insert into PHIEUMUON_INFO values ('"+p.getidReader()+"','"+p.getIdPhieumuon()+"','"+p.getNgaymuon()+"','"+p.getThoihanmuon()+"','"+p.getFullname()+"','"
							+p.getSoluong()+"','"+p.getTiencoc()+"')";
					var statement = con.conn.prepareStatement(sql);
					statement.executeUpdate();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
					

			}
		});
		
		 dateChooser = new JDateChooser();
		 dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton huyboButton = new JButton("Hủy bỏ");
		huyboButton.setForeground(Color.RED);
		huyboButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		fullnametxt = new JTextField();
		fullnametxt.setColumns(10);
		
		phonenumbertxt = new JTextField();
		phonenumbertxt.setColumns(10);
		
		JButton btnNewButton = new JButton("In Phiếu");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String item = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
				try {
					var sql = "select fullname,phonenumber from READER_INFO where idReader='"+item+"'";
					var statement = con.conn.prepareStatement(sql);
					var result = statement.executeQuery();
					while(result.next()) {
						fullnametxt.setText(result.getString("fullname"));
						phonenumbertxt.setText(result.getString("phonenumber"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ádsa"}));
		combomodel = new DefaultComboBoxModel<>();
		for(var s: listidReader) {
			combomodel.addElement(s);
		}
		comboBox.setModel(combomodel);
		
		JLabel lblNewLabel_12 = new JLabel("Phí đặt cọc");
		lblNewLabel_12.setForeground(Color.BLUE);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tiendatcoctxt = new JTextField();
		tiendatcoctxt.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("VND");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton_1 = new JButton("payment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer sum = 0;
				for(int i=0;i<model.getRowCount();i++) {
					sum += Integer.valueOf((String) model.getValueAt(i, 2));
				}
				tiendatcoctxt.setText(String.valueOf(sum*5000));
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_7)
										.addComponent(lblNewLabel_8)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_9)
										.addComponent(lblNewLabel_10))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(phonenumbertxt, Alignment.LEADING)
									.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(fullnametxt, Alignment.LEADING, 128, 128, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(huyboButton)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_12)
									.addGap(24)
									.addComponent(tiendatcoctxt, 143, 143, 143)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_13)))
					.addGap(26))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(luuButton)
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addComponent(btnNewButton)
					.addContainerGap(123, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(122, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(95))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_5)
					.addGap(47)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(fullnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(phonenumbertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_10)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(tiendatcoctxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13))
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(luuButton)
						.addComponent(huyboButton))
					.addGap(17)
					.addComponent(btnNewButton))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
