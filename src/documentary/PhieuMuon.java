package documentary;

import java.util.ArrayList;

public class PhieuMuon {
	private String idPhieumuon;//ma phieu muon co dang PM_xxxxxx. Vd : PM_12356
	private String ngaymuon;
	private String thoihanmuon;
	private String idReader;
	private Integer soluong;
	private String fullname;
	private int tiencoc;
//	private ArrayList<Book> listbook = new ArrayList<>();
	public PhieuMuon(){
		
	}
	public PhieuMuon(String idphieumuon,String idreader,String fullname, String ngaymuon, String thoihanmuon, Integer soluong,int tiencoc){
		this.idPhieumuon = idphieumuon;
		this.ngaymuon = ngaymuon;
		this.thoihanmuon = thoihanmuon;
		this.idReader = idReader;
		this.fullname = fullname;
		this.tiencoc = tiencoc;
		this.soluong = soluong;
	}
	
	public void setIdPhieumuon(String idPhieumuon) {
		this.idPhieumuon = idPhieumuon;
	}
	
	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	
	public void setThoihanmuon(String thoihanmuon) {
		this.thoihanmuon = thoihanmuon;
	}
	
	public void setidReader(String idReader) {
		this.idReader = idReader;
	}

	
	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}
	
	public void setTiencoc(int tiencoc) {
		this.tiencoc = tiencoc;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getIdPhieumuon() {
		return idPhieumuon;
	}
	
	public String getNgaymuon() {
		return ngaymuon;
	}
	
	public String getThoihanmuon() {
		return thoihanmuon;
	}
	
	public String getidReader() {
		return idReader;
	}

	public Integer getSoluong() {
		return soluong;
	}
	
	public int getTiencoc() {
		return tiencoc;
	}
	
	public String getFullname() {
		return fullname;
	}
}
