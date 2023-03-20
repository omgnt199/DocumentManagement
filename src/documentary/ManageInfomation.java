package documentary;

import java.sql.SQLException;

interface ManageInfomation {
	
	public void themsach() throws SQLException,ClassNotFoundException;
	public void suathongtin(String masach) throws SQLException;
	public void xoa(String ms) throws SQLException;
	public void timkiem() throws SQLException;
	
	
}
