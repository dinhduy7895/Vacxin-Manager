package model.bean;

public class Benh {
	private String name;
	private String mota;
	private int MaBenh;
	public Benh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getMaBenh() {
		return MaBenh;
	}
	public void setMaBenh(int maBenh) {
		MaBenh = maBenh;
	}
	public Benh(String name, String mota, int maBenh) {
		super();
		this.name = name;
		this.mota = mota;
		MaBenh = maBenh;
	}
	
}
