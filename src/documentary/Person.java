package documentary;

import java.sql.Date;

public class Person {
	private String pID;
	private String fullname;
	private String address;
	private Date age;//Ngay thang nam sinh.
	private String sex;
	
	public Person(){
		
	}
	public Person(String pid, String fullname, String address, Date age, String sex){
		this.pID = pid;
		this.fullname = fullname;
		this.address = address;
		this.age = age;
		this.sex = sex;
	}
	
	public void setpID(String pID) {
		this.pID = pID;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getpID() {
		return pID;
	}
	public String getFullname() {
		return fullname;
	}
	public String getAddress() {
		return address;
	}
	public Date getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	
}
