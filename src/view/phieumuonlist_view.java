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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import documentary.Book;
import documentary.PhieuMuon;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class phieumuonlist_view extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Integer totalpage = 1;
	private Integer totalvalue = 0 ;
	private Integer valueperpage = 5;
	private Integer page =1;
	private JButton lastButton;
	private JButton nextButton;
	private JButton firstButton;
	private JButton prevButton;
	private JLabel totalpagelbl;
	private JLabel pageforpagelbl;
	private DefaultTableModel model;
	private ArrayList<PhieuMuon> list = new ArrayList<>();
	private JComboBox comboBox;
	private ConnectSQL con;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phieumuonlist_view frame = new phieumuonlist_view();
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
	public phieumuonlist_view() throws ClassNotFoundException, NullPointerException, SQLException {
		phieumuonList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		 nextButton = new JButton("Next");
		 nextButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(page<totalpage) {
		 			page++;
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
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20"}));
		
		prevButton = new JButton("Prev");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page>1) {
					page--;
					initPagination();
				}
			}
		});
		
		 lastButton = new JButton("Last");
		lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = totalpage;
				initPagination();
			}
		});
		
		totalpagelbl = new JLabel("1");
		
		pageforpagelbl = new JLabel("Page 1 for 1");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(654, Short.MAX_VALUE)
					.addComponent(lastButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(prevButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(nextButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firstButton)
					.addGap(11))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 941, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pageforpagelbl)
					.addPreferredGap(ComponentPlacement.RELATED, 817, Short.MAX_VALUE)
					.addComponent(totalpagelbl)
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nextButton)
						.addComponent(firstButton)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(prevButton)
						.addComponent(lastButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalpagelbl)
						.addComponent(pageforpagelbl))
					.addGap(123))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idPhieuMuon", "idReader", "Họ và tên", "Ngày mượn", "Hạn trả", "Số lượng sách mượn", "Tiền cọc"
			}
		));
		model = (DefaultTableModel) table.getModel();
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
		 totalpagelbl.setText("TotalPage:"+totalpage);
		 pageforpagelbl.setText("Page "+page+"for "+totalpage);
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
			 PhieuMuon p = new PhieuMuon();
			 p = list.get(i);
			 model.addRow(new Object[] {
					 p.getIdPhieumuon(),p.getidReader(),p.getFullname(),p.getNgaymuon(),p.getThoihanmuon(),p.getSoluong(),p.getTiencoc()
			 });
		 }
		 
	}
	 
	public void phieumuonList() throws ClassNotFoundException, NullPointerException, SQLException {
		con = new ConnectSQL();
		var sql = "select * from PHIEUMUON_INFO";
		var statement = con.conn.prepareStatement(sql);
		var result = statement.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		while(result.next()) {
			PhieuMuon p = new PhieuMuon();
			p.setIdPhieumuon(result.getString("idPhieuMuon"));
			p.setidReader(result.getString("idReader"));
			p.setFullname(result.getString("fullname"));
			p.setNgaymuon(sdf.format(result.getDate("ngaymuon")));
			p.setThoihanmuon(sdf.format(result.getDate("thoihanmuon")));
			p.setSoluong(result.getInt("soluong"));
			p.setTiencoc(result.getInt("tiencoc"));
			list.add(p);
		}
		
	}
}
