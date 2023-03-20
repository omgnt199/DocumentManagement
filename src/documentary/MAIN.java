package documentary;

import java.io.IOException;
import java.sql.*;


import view.MENU_LIBRARY;
import view.login_view;
public class MAIN   {
	public void showMenu() {
		
		System.out.println();
	}
//
//    private static void showResutl(ResultSet resultSet) throws SQLException {
//    	System.out.printf("%20s%20s%20s%20s%20s%20s\n","DocumentName","Author","Year","Amount","IdB","Type");
//        while (resultSet.next()){
//            var tensach = resultSet.getString("DocumentName");
//            var tacgia = resultSet.getString("Author");
//            var nsx = resultSet.getInt("Year");
//            var soluong = resultSet.getInt("Amount");
//            var idb = resultSet.getString("IdB");
//            var type = resultSet.getString("Type");
//            System.out.printf("%20s%20s%20d%20d%20s%20s\n",tensach,tacgia,nsx,soluong,idb,type);
//
//        }
//
//    }
    
    
	public static void main(String[] args) throws ClassNotFoundException,SQLException,NullPointerException, IOException {
			new login_view();

	    }

		
}
