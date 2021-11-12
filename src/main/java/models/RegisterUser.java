package models;

public class RegisterUser {
	private String name;
	private String nganh;
	private String gt;
	private String[] nganhMongMuon;
	
	public RegisterUser() {
		//
	}

	public RegisterUser(String name, String nganh, String gt, String[] nganhMongMuon) {
		super();
		this.name = name;
		this.nganh = nganh;
		this.gt = gt;
		this.nganhMongMuon = nganhMongMuon;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	public String getGt() {
		return gt;
	}
	public void setGt(String gt) {
		this.gt = gt;
	}
	public String[] getNganhMongMuon() {
		return nganhMongMuon;
	}
	public void setNganhMongMuon(String[] nganhMongMuon) {
		this.nganhMongMuon = nganhMongMuon;
	}
	
	
}
