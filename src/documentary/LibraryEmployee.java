package documentary;

import java.sql.Date;

public class LibraryEmployee extends Person {
	private String idLE;//Ma nhan vien co dang "NVTV_xxxx" vd:NVTV_0099
	private String vaitro;
	private String caLamviec;
	
	LibraryEmployee(){
		
	}
	LibraryEmployee(String pid, String fullname, String address, Date age, String sex, String idLE, String vaitro, String calamviec){
		super(pid,fullname,address,age,sex);
		this.idLE = idLE;
		this.vaitro = vaitro;
		this.caLamviec = calamviec;
	}
	public void setIdLE(String idLE) {
		this.idLE = idLE;
	}
	
	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}
	
	public void setCaLamviec(String caLamviec) {
		this.caLamviec = caLamviec;
	}
	
	public String getIdLE() {
		return idLE;
	}
	
	public String getVaitro() {
		return vaitro;
	}
	
	public String getCaLamviec() {
		return caLamviec;
	}
	
	
}
