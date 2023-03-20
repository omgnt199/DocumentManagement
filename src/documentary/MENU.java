package documentary;

import java.sql.*;
import java.util.Scanner;

public class MENU extends ConnectSQL implements ManageInfomation {
	public Book book = new Book();
	public MENU() throws ClassNotFoundException, SQLException {
		super();
	}
	

	@Override
	public void themsach() throws SQLException,NullPointerException {

		String s1=String.valueOf(book.Year);
		String s2=String.valueOf(book.Amount);
		var them = "insert into BOOK_INFO "+"VALUES('"+book.idB+"','"+book.DocumentName+"','"+book.Author+"','"+s1+"','"+s2+"','"+book.type+"')";
		var insert = conn.prepareStatement(them);
		insert.executeUpdate();
		
	}

	@Override
	public void suathongtin(String ms) throws SQLException {

		var bookinfo = "select * from BOOK_INFO where IdB = '" + ms +"'";

		var sua = conn.prepareStatement(bookinfo);
		if(sua.getUpdateCount()==-1)
		{
			System.out.println("Khong dau` sach nao` co ma sach nhu ban nhap trong thu vien");
		}
		else
		{
			System.out.println("Thong tin hien tai ma sach can sua : ");
			var resultSet = sua.executeQuery();
			System.out.printf("%20s%20s%20s%20s%20s%20s\n","IdB","DocumentName","Author","Year","Amount","Type");
			while(resultSet.next())
			{
	        var tensach = resultSet.getString("DocumentName");
	        var tacgia = resultSet.getString("Author");
	        var nsx = resultSet.getInt("Year");
	        var soluong = resultSet.getInt("Amount");
	        var idb = resultSet.getString("IdB");
	        var type = resultSet.getString("Type");
	        System.out.printf("%20s%20s%20d%20d%20s%20s\n",tensach,tacgia,nsx,soluong,idb,type);
			}
	        System.out.println("Thong tin muon sua:");
	        Book b =  new Book();
//	        b.setinfo();
	        String s1 = String.valueOf(b.Year);
	        String s2 = String.valueOf(b.Amount);
	       
			var thongtin = "update BOOK_INFO set DocumentName='"+b.DocumentName+"',Author='"+b.Author+"',Year="+s1+",Amount="
					+s2+",IdB='"+b.idB+"',Type='"+b.type+"' where Idb ='"+ms+"'";
			var suatt = conn.prepareStatement(thongtin);
			suatt.executeUpdate();		
		}

	}

	@Override
	public void xoa(String ms) throws SQLException {
		var xoatt = "DELETE FROM BOOK_INFO WHERE Idb ='" + ms + "'";
		var xoatt_th = conn.prepareStatement(xoatt);
		xoatt_th.executeUpdate();
		
	}

	@Override
	public void timkiem() throws SQLException  {
		System.out.println("Ban muon tim kiem theo :");
		System.out.println("1.Ten sach");
		System.out.println("2.Ten tac gia");
		System.out.println("3.Nam xuat ban");
		System.out.println("4.The loai");
		System.out.println("Lua chon cua ban:");
		try(Scanner sc=new Scanner(System.in))  {
			int luachon;
			luachon=sc.nextInt();
			sc.nextLine();
			String timkiemtt;
			PreparedStatement timkiemtt_th;
			ResultSet resultset;
			switch(luachon) {
			
				case 1:
					String tensach;
					System.out.println("Nhap ten sach muon tim: ");
					tensach = sc.nextLine();
					timkiemtt="select * from BOOK_INFO where DocumentName ='"+tensach+"'";
					timkiemtt_th = conn.prepareStatement(timkiemtt);
					resultset = timkiemtt_th.executeQuery();
					showResutl(resultset);
					break;
				case 2:
					String tentacgia;
					System.out.println("Nhap ten tac gia muon tim: ");
					tentacgia = sc.nextLine();
					timkiemtt="select * from BOOK_INFO where Author ='"+tentacgia+"'";
					timkiemtt_th = conn.prepareStatement(timkiemtt);
					resultset = timkiemtt_th.executeQuery();
					showResutl(resultset);
					break;
				case 3:
					int year;
					System.out.println("Nhap nam xuat ban muon tim: ");
					year = sc.nextInt();
					String y = String.valueOf(year);
					timkiemtt = "select * from BOOK_INFO where Year = "+y;
					timkiemtt_th = conn.prepareStatement(timkiemtt);
					resultset = timkiemtt_th.executeQuery();
					showResutl(resultset);
					break;
				case 4:
					String theloai;
					System.out.println("Nhap the loai muon tim: ");
					theloai = sc.nextLine();
					timkiemtt = "select * from BOOK_INFO where Type='"+theloai+"'";
					timkiemtt_th = conn.prepareStatement(timkiemtt);
					resultset = timkiemtt_th.executeQuery();
					showResutl(resultset);
					break;
					
			}

		}

		
	}
	

    public static void showResutl(ResultSet resultSet) throws SQLException {
    	System.out.printf("%20s%20s%20s%20s%20s%20s\n","DocumentName","Author","Year","Amount","IdB","Type");
        while (resultSet.next()){
            var tensach = resultSet.getString("DocumentName");
            var tacgia = resultSet.getString("Author");
            var nsx = resultSet.getInt("Year");
            var soluong = resultSet.getInt("Amount");
            var idb = resultSet.getString("IdB");
            var type = resultSet.getString("Type");
            System.out.printf("%20s%20s%20d%20d%20s%20s\n",tensach,tacgia,nsx,soluong,idb,type);

        }

    }
    
}
