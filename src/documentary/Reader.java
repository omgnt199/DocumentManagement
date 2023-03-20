package documentary;

import java.sql.Date;

public class Reader extends Person {
	private String idReader;
	private String typeReader;
	private String phonenumber;
	private String email;
	
	public Reader(){
		
	}
	
	public Reader(String pid, String fullname, String address, Date age, String sex, String idreader, String typeReader, String phonenumber
			,String email){
		super(pid,fullname,address,age,sex);
		this.idReader = idreader;
		this.typeReader = typeReader;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setIdReader(String idReader) {
		this.idReader = idReader;
	}
	public void setTypeReader(String typeReader) {
		this.typeReader = typeReader;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getIdReader() {
		return idReader;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public String getTypeReader() {
		return typeReader;
	}
	
}
