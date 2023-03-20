package view;
import documentary.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class sach extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollpane;
	private ConnectSQL con = new ConnectSQL();
	private ArrayList<Book> list = new ArrayList<Book>();
	private JTable table;
	private DefaultTableModel model;
	private Integer totalpage = 1;
	private Integer totalvalue = 0 ;
	private Integer valueperpage = 5;
	private JComboBox comboBox;
	private Integer page =1;
	private JButton lastButton;
	private JButton nextButton;
	private JButton firstButton;
	private JButton prevButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sach frame = new sach();
					frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch(NullPointerException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public void bookinLib() {
		try
		{
			var sql = "select * from BOOK_INFO";
			var show = con.conn.prepareStatement(sql);
			var result = show.executeQuery();
			while(result.next())
			{
				Book b = new Book();
				b.setDocumentName(result.getString("DocumentName"));
				b.setAuthor(result.getString("Author"));
				b.setYear(result.getInt("Year"));
				b.setAmount(result.getInt("Amount"));
				b.setIdB(result.getString("IdB"));
				b.setType(result.getString("Type"));
				list.add(b);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		}

	}
	public sach() throws SQLException,NullPointerException,ClassNotFoundException {
		bookinLib();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("SÁCH THƯ VIỆN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DocumentControl();
			}
		});
		btnNewButton.setForeground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "30"}));
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
                initPagination();
			}
		});
	
		lastButton = new JButton("Last");
		lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = totalpage;
				initPagination();
			}
		});
		
		prevButton = new JButton("Prev");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page>1) {
					page--;
					initPagination();
				}
			}
		});
		
		firstButton = new JButton("First");
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = 1;
				initPagination();
			}
		});
		
		 nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page<totalpage) {
					page++;
					initPagination();
				}

			}
		});
		
		 lblNewLabel_1 = new JLabel("TotalPage : 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		 lblNewLabel_2 = new JLabel("Page 1 for 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(139)
					.addComponent(lastButton)
					.addGap(38)
					.addComponent(prevButton)
					.addGap(41)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(nextButton)
					.addGap(35)
					.addComponent(firstButton)
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, 515, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addGap(103)
							.addComponent(btnNewButton)
							.addGap(76))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 882, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lastButton)
								.addComponent(prevButton)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nextButton)
								.addComponent(firstButton))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_2))
						.addComponent(btnNewButton)))
		);

		table = new JTable();
		table.setForeground(Color.BLUE);
		table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"DocumentName", "Author", "Year", "Amount", "IdB", "Type"
					}
		));
		model=(DefaultTableModel) table.getModel();
		initPagination();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	 public void initPagination() {
		 model.setRowCount(0);
		 totalvalue = list.size();
		 valueperpage = Integer.parseInt((String) comboBox.getItemAt(comboBox.getSelectedIndex()));

		 Double totalpageD = Math.ceil(totalvalue.doubleValue()/valueperpage.doubleValue());
		 totalpage = totalpageD.intValue();
		 lblNewLabel_1.setText("TotalPage:"+totalpage);
		 lblNewLabel_2.setText("Page "+page+"for "+totalpage);
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
			 Book b = new Book();
			 b  = list.get(i);
			 model.addRow(new Object[] {
					 b.getDocumentName(),b.getAuthor(),b.getYear(),b.getAmount(),b.getIdB(),b.getIdB()
			 });
		 }
		 
	}
}
